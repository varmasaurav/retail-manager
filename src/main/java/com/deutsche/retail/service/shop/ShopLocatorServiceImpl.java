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
        // Query string for the Geo API
        Shop.ShopAddress shop_address = shop.getShopAddress();
        StringBuilder address = new StringBuilder(shop_address.getNumber()).append(".").append(shop_address.getPostCode());
        // Get the latitude & longitude
        Location location = geoApiResolver(address.toString());
        // Create Shop details with shop and its location
        ShopWithLocation shop_with_location = new ShopWithLocation(shop);
        shop_with_location.setShopLatLong(location.getLatitude(), location.getLongitude());
        // Add it to in-memory db
        shopListHolder.add(shop_with_location);
    }

    @Override
    public ShopWithLocation nearest(Location location) {
        List<ShopWithLocation> all = shopListHolder.getAll();
        // Minimum is 0.0 since distance with itself will be 0
        double nearest = calculateDistance(location, all.get(0).getLocation());
        double temp;
        ShopWithLocation nearest_shop = all.get(0);

        // TODO: 29/8/16 - What happens if the list is very big, Need to think of a better data structure. Use BST?
        for(int i=1; i < all.size() ; i++) {
            temp = calculateDistance(location, all.get(i).getLocation());
            /** If distance of shops are equal, the first one found is returned
             *  Since '<' is used in comparison
             */
            if (temp < nearest) {
                nearest = temp;
                nearest_shop = all.get(i);
            }
        }
        
        if(nearest == 0.0) {
            // Same Shop
        }
        return nearest_shop;
    }

    @Override
    public List<ShopWithLocation> getAll() {
        return shopListHolder.getAll();
    }

    public static Location geoApiResolver(String address_in_one_line) {
        // TODO: 29/8/16 Removing hard coding (read from file or db), Secret key should be encrypted
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

    private Double calculateDistance(Location l1, Location l2) {
        Double diff_lat = l1.getLatitude() - l2.getLongitude();
        Double diff_lon = l1.getLongitude() - l2.getLongitude();

        return Math.sqrt(diff_lat * diff_lat + diff_lon * diff_lon);
    }

}
