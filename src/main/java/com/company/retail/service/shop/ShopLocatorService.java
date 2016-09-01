package com.company.retail.service.shop;

import com.company.retail.models.Location;
import com.company.retail.models.Shop;
import com.company.retail.models.ShopWithLocation;

import java.util.List;

/**
 * Exposed Shop related API from the application
 * Created by saurav on 28/8/16.
 */
public interface ShopLocatorService {

    /**
     * Gets the latitude and longitude & saves it as {@link ShopWithLocation}
     * with other information passed in argument as {@link Shop}
     * @param shop
     */
    void save(Shop shop);

    /**
     * Gets the Shop details along with latitude and longitude as {@link ShopWithLocation}
     * given {@link Location}
     * @param {@link Location}
     * @return {@link ShopWithLocation}
     */
    ShopWithLocation nearest(Location location);

    /**
     * Gets the list of shops (Added for testing purpose)
     */
    List<ShopWithLocation> getAll();
}
