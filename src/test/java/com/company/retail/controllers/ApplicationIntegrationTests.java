package com.company.retail.controllers;

import com.company.retail.BaseTest;
import com.company.retail.models.Shop;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

/**
 * Created by saurav on 1/9/16.
 */

public class ApplicationIntegrationTests extends BaseTest {


    @Before
    public void setUp() {
        ShopController shopController = new ShopController();
        shopController.setShopLocatorService(shopLocatorService);
        RestAssuredMockMvc.standaloneSetup(shopController);
    }

    @Test
    public void testApplicationStatus() {
        // Verfies application is up & running
        given().when().get("/").then().statusCode(200);
    }

    @Test
    public void testAddShopWithMissingBody() {
        // Bad request
        given().when().post("/addShop").then().statusCode(400);
    }

    @Test
    public void testAddShopWithValidShop() {
        Shop shop = new Shop();
        shop.setShopName("New Shop");
        shop.setShopAddress(new Shop.ShopAddress("Address", 123));

        given().contentType("application/json").body(shop).when().post("/addShop").then().statusCode(200);
    }
}
