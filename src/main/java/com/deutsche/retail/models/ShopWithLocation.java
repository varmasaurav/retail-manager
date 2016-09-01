package com.deutsche.retail.models;

/**
 * Model class to hold shop data with location attributes
 * Created by saurav on 28/8/16.
 */
public class ShopWithLocation extends Shop {
    protected String shopLatitude;
    protected String shopLongitude;

    public ShopWithLocation(String shopLatitude, String shopLongitude) {
        this.shopLatitude = shopLatitude;
        this.shopLongitude = shopLongitude;
    }

    public String getShopLatitude() {
        return shopLatitude;
    }

    public void setShopLatitude(String shopLatitude) {
        this.shopLatitude = shopLatitude;
    }

    public String getShopLongitude() {
        return shopLongitude;
    }

    public void setShopLongitude(String shopLongitude) {
        this.shopLongitude = shopLongitude;
    }

}
