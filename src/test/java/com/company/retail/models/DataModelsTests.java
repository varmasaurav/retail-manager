package com.company.retail.models;

import com.company.retail.BaseTest;
import com.company.retail.db.ShopListHolder;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by saurav on 28/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DataModelsTests extends BaseTest {

    @Test
    public void testShopModel() throws JsonProcessingException {
        Shop shop = new Shop();
        shop.setShopName("Test Shop");
        shop.setShopAddress(new Shop.ShopAddress("1234", 600078));

        String expected = "{\"shopName\" : \"Test Shop\",\"shopAddress\" : {\"number\": \"1234\",\"postCode\" : 600078}}";
        String actual = objectMapper.writeValueAsString(shop);

        JSONAssert.assertEquals(expected, actual, false);

        Shop shop_2 = new Shop();
        shop_2.setShopName("Test Shop");
        shop_2.setShopAddress(new Shop.ShopAddress("1234", 600078));

        assert(shop.equals(shop_2));

        shop_2.setShopName("test name");
        assert(!shop.equals(shop_2));
    }

    @Test
    public void testShopWithLocationModel() throws JsonProcessingException {
        ShopWithLocation shop = new ShopWithLocation(new Location(78.903, 81.09));
        shop.setShopName("Test Shop");
        shop.setShopAddress(new Shop.ShopAddress("1234", 600078));

        String expected = "{\"shopName\" : \"Test Shop\",\"shopAddress\" : {\"number\": \"1234\",\"postCode\" : 600078}, \"shopLatitude\": 78.903, \"shopLongitude\" : 81.09}";
        String actual = objectMapper.writeValueAsString(shop);

        JSONAssert.assertEquals(expected, actual, false);

        ShopWithLocation shop_2 = new ShopWithLocation(new Location(78.903, 81.09));
        shop_2.setShopName("Test Shop");
        shop_2.setShopAddress(new Shop.ShopAddress("1234", 600078));
        assert(shop.equals(shop_2));

        shop_2.setShopName("test name");
        assert(!shop.equals(shop_2));
    }

    @Test
    public void testLocationModel() {
        Location location_1 = new Location(34.9090, 80.89);
        Location location_2 = new Location(34.9090, 80.89);
        assert(location_1.equals(location_2));

        location_1 = new Location(0.00, 0.000);
        location_2 = new Location(0.0, 0.0);
        assert(location_1.equals(location_2));
    }

    @Test
    public void testShopListHolder() {
        ShopListHolder shopListHolder = new ShopListHolder();
        ShopWithLocation shop = new ShopWithLocation(new Location(78.903, 81.09));
        shop.setShopName("Test Shop");
        shop.setShopAddress(new Shop.ShopAddress("1234", 600078));
        shopListHolder.add(shop);
        Assert.assertTrue(shop.equals(shopListHolder.get(0)));
        ShopWithLocation shop2 = new ShopWithLocation(new Location(78.903, 81.09));
        shop.setShopName("Test Shop");
        shop.setShopAddress(new Shop.ShopAddress("1234", 600078));
        shopListHolder.add(shop2);

        Assert.assertTrue(shopListHolder.getAll().size() == 2);

        shopListHolder.remove(shop);
        Assert.assertTrue(shopListHolder.getAll().size() == 1);
        Assert.assertTrue(shop2.equals(shopListHolder.get(0)));

        shopListHolder.remove(0);
        Assert.assertTrue(shopListHolder.getAll().size() == 0);
    }
}
