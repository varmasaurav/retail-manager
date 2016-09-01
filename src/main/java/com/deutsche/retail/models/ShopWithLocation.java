package com.deutsche.retail.models;

/**
 * Response Model class to hold shop data with location attributes
 * Created by saurav on 28/8/16.
 */
public class ShopWithLocation extends Shop {
    protected Double shopLatitude;
    protected Double shopLongitude;

    public ShopWithLocation(Double shopLatitude, Double shopLongitude) {
        this.shopLatitude = shopLatitude;
        this.shopLongitude = shopLongitude;
    }

    public Double getShopLatitude() {
        return shopLatitude;
    }

    public void setShopLatitude(Double shopLatitude) {
        this.shopLatitude = shopLatitude;
    }

    public Double getShopLongitude() {
        return shopLongitude;
    }

    public void setShopLongitude(Double shopLongitude) {
        this.shopLongitude = shopLongitude;
    }

}
