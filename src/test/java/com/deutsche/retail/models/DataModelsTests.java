package com.deutsche.retail.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * Created by saurav on 28/8/16.
 */
public class DataModelsTests {
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testShopModel() throws JsonProcessingException {
        Shop shop = new Shop();
        shop.setShopName("Test Shop");
        shop.setShopAddress(new Shop.ShopAddress("1234", 600078));

        String expected = "{\"shopName\" : \"Test Shop\",\"shopAddress\" : {\"number\": \"1234\",\"postCode\" : 600078}}";
        String actual = mapper.writeValueAsString(shop);

        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    public void testShopWithLocationModel() throws JsonProcessingException {
        ShopWithLocation shop = new ShopWithLocation(78.903, 81.09);
        shop.setShopName("Test Shop");
        shop.setShopAddress(new Shop.ShopAddress("1234", 600078));

        String expected = "{\"shopName\" : \"Test Shop\",\"shopAddress\" : {\"number\": \"1234\",\"postCode\" : 600078}, \"shopLatitude\": 78.903, \"shopLongitude\" : 81.09}";
        String actual = mapper.writeValueAsString(shop);

        JSONAssert.assertEquals(expected, actual, false);
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
}
