package com.deutsche.retail.service;

import com.deutsche.retail.models.Location;
import com.deutsche.retail.models.Shop;
import com.deutsche.retail.models.ShopWithLocation;
import com.deutsche.retail.service.shop.ShopLocatorService;
import com.deutsche.retail.service.shop.ShopLocatorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by saurav on 29/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/test-spring-context.xml"})
public class ShopServiceTests {

    @Autowired
    public ShopLocatorService shopLocatorService;

    @Test
    public void testGeoApiResolver() {
        String address = "1600 Amphitheatre Parkway Mountain View, CA".concat(",").concat(94043 + "");
        Location location = ShopLocatorServiceImpl.geoApiResolver(address);
        assert(location.equals(new Location(37.4223269, -122.084401)));
    }

    @Test
    public void testSave() {
        Shop shop = new Shop();
        shop.setShopName("Test Shop");
        shop.setShopAddress(new Shop.ShopAddress("1600 Amphitheatre Parkway Mountain View, CA", 94043));
        shopLocatorService.save(shop);

        ShopWithLocation shop_with_location = new ShopWithLocation();
        shop_with_location.setShopName(shop.getShopName());
        shop_with_location.setShopAddress(shop.getShopAddress());
        shop_with_location.setShopLatLong(37.4223269, -122.084401);
        assert(shopLocatorService.getAll().get(0).equals(shop_with_location));
    }
}
