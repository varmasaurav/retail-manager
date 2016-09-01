package com.deutsche.retail.service.shop;

import com.deutsche.retail.models.Location;
import com.deutsche.retail.models.Shop;
import com.deutsche.retail.models.ShopWithLocation;

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
}
