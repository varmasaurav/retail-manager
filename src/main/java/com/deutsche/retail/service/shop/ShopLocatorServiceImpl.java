package com.deutsche.retail.service.shop;

import com.deutsche.retail.models.Location;
import com.deutsche.retail.models.Shop;
import com.deutsche.retail.models.ShopWithLocation;


/**
 * Created by saurav on 28/8/16.
 */
public class ShopLocatorServiceImpl implements ShopLocatorService {

    @Override
    public void save(Shop shop) {
        // TODO: 28/8/16
    }

    @Override
    public ShopWithLocation nearest(Location location) {
        ShopWithLocation shop = new ShopWithLocation("", "");
        // TODO: 29/8/16  
        return shop;
    }
}
