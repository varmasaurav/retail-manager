package com.deutsche.retail.models;

/**
 * Request Model class to hold shop data
 * Created by saurav on 28/8/16.
 */
public class Shop {
    protected String shopName;
    protected ShopAddress shopAddress;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ShopAddress getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(ShopAddress shopAddress) {
        this.shopAddress = shopAddress;
    }


    public static class ShopAddress {
        private String number;
        private int postCode;

        public ShopAddress(String number, int postCode) {
            this.number = number;
            this.postCode = postCode;
        }
        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public int getPostCode() {
            return postCode;
        }

        public void setPostCode(int postCode) {
            this.postCode = postCode;
        }
    }
}
