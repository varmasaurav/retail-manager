package com.deutsche.retail.service.shop;

import com.deutsche.retail.db.ShopListHolder;
import com.deutsche.retail.models.Location;
import com.deutsche.retail.models.Shop;
import com.deutsche.retail.models.ShopWithLocation;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by saurav on 28/8/16.
 */
public class ShopLocatorServiceImpl implements ShopLocatorService {
    @Autowired
    private ShopListHolder shopListHolder;

    @Override
    public void save(Shop shop) {
        ShopWithLocation shop_with_location = new ShopWithLocation();
        shop_with_location.setShopName(shop.getShopName());
        shop_with_location.setShopAddress(shop.getShopAddress());
        Shop.ShopAddress shop_address = shop.getShopAddress();
        StringBuilder address = new StringBuilder(shop_address.getNumber()).append(".").append(shop_address.getPostCode());
        Location location = geoApiResolver(address.toString());
        shop_with_location.setShopLatLong(location.getLatitude(), location.getLongitude());
        shopListHolder.add(shop_with_location);
    }

    @Override
    public ShopWithLocation nearest(Location location) {
        ShopWithLocation shop = new ShopWithLocation(null, null);
        // TODO: 29/8/16
        return shop;
    }

    @Override
    public List<ShopWithLocation> getAll() {
        return shopListHolder.getAll();
    }

    public static Location geoApiResolver(String address_in_one_line) {
        // TODO: 29/8/16 Removing hard coding (read from file or db)
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCuJmJrMJvMzu_4ZgMpK7dJiV_26sBwBJ0");
        try {
            GeocodingResult result = GeocodingApi.geocode(context, address_in_one_line).await()[0];
            LatLng location = result.geometry.location;
            return new Location(location.lat,location.lng);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Location(null, null);
    }

    public ShopListHolder getShopListHolder() {
        return shopListHolder;
    }

    public void setShopListHolder(ShopListHolder shopListHolder) {
        this.shopListHolder = shopListHolder;
    }

}
