package com.deutsche.retail.service.shop;

import com.deutsche.retail.models.Location;
import com.deutsche.retail.models.Shop;
import com.deutsche.retail.models.ShopWithLocation;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;


/**
 * Created by saurav on 28/8/16.
 */
public class ShopLocatorServiceImpl implements ShopLocatorService {

    @Override
    public void save(Shop shop) {
        // TODO: 29/8/16
    }

    @Override
    public ShopWithLocation nearest(Location location) {
        ShopWithLocation shop = new ShopWithLocation(null, null);
        // TODO: 29/8/16
        return shop;
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

}
