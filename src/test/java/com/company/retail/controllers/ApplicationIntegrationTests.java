package com.company.retail.controllers;

import com.company.retail.BaseTest;
import com.company.retail.db.ShopListHolder;
import com.company.retail.main.Messages;
import com.company.retail.models.Shop;
import com.company.retail.service.shop.ShopLocatorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ShopListHolder shopListHolder = new ShopListHolder();
        ShopLocatorServiceImpl shopLocatorService = new ShopLocatorServiceImpl();
        shopLocatorService.setShopListHolder(shopListHolder);
        ShopController shopController = new ShopController();
        shopController.setShopLocatorService(shopLocatorService);
        shopController.setObjectMapper(new ObjectMapper());
        RestAssuredMockMvc.standaloneSetup(shopController);
    }

    @Test
    public void testApplicationStatus() {
        // Verfies application is up & running
        given().when().get("/").then().statusCode(200);
    }

    @Test
    public void testAddShop() {
        // Bad request - Missing body
        given().when().post("/shop/add").then().statusCode(400);
        Shop shop = new Shop();
        shop.setShopName("New Shop");
        // Missing Address
        given().contentType("application/json").body(shop).when().post("/shop/add").then().statusCode(400);

        // Address is needed in a request body
        shop.setShopAddress(new Shop.ShopAddress("Address", 123));
        given().contentType("application/json").body(shop).when().post("/shop/add").then().statusCode(201);
    }

    @Test
    public void testResponseJson() {
        // Bad Request since request param is null
        given().when().get("/shop/nearest?customerLatitude=&customerLongitude").then().statusCode(400);
        // Bad Request since request param's value is invalid
        given().when().get("/shop/nearest?customerLatitude=qwertyu&customerLongitude=tyu").then().statusCode(400);
        // No shops has been added yet
        given().when().get("/shop/nearest?customerLatitude=10&customerLongitude=89").then().statusCode(200).assertThat(
                result -> {result.toString().equals(Messages.NO_SHOPS_ADDED);}
        );
    }
}

