package com.deutsche.retail.service;

import com.deutsche.retail.models.Location;
import com.deutsche.retail.service.shop.ShopLocatorServiceImpl;
import org.junit.Test;

/**
 * Created by saurav on 29/8/16.
 */
public class ShopServiceTests {

    @Test
    public void testGeoApiResolver() {
        String address = "1600 Amphitheatre Parkway Mountain View, CA".concat(",").concat(94043 + "");
        Location location = ShopLocatorServiceImpl.geoApiResolver(address);
        assert(location.equals(new Location(37.4223269, -122.084401)));
    }
}
