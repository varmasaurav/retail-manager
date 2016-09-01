package com.deutsche.retail.service.shop;

import com.deutsche.retail.models.Shop;

/**
 * Exposed Shop related API from the application
 * Created by saurav on 28/8/16.
 */
public interface ShopLocatorService {

    /**
     * Gets the latitude and longitude & saves it as {@link com.deutsche.retail.models.ShopWithLocation}
     * with other information passed in argument as {@link Shop}
     * @param shop
     */
    void save(Shop shop);
}
