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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopWithLocation that = (ShopWithLocation) o;

        if (shopName != null ? !shopName.equals(that.shopName) : that.shopName != null) return false;
        if (shopLatitude != null ? !shopLatitude.equals(that.shopLatitude) : that.shopLatitude != null) return false;
        return shopLongitude != null ? shopLongitude.equals(that.shopLongitude) : that.shopLongitude == null;

    }

    @Override
    public int hashCode() {
        int result = shopLatitude != null ? shopLatitude.hashCode() : 0;
        result = 31 * result + (shopLongitude != null ? shopLongitude.hashCode() : 0);
        result = 11 * result + (shopName != null ? shopName.hashCode() : 0);
        return result;
    }

    public Double getShopLongitude() {
        return shopLongitude;
    }

    public void setShopLongitude(Double shopLongitude) {
        this.shopLongitude = shopLongitude;
    }

}
