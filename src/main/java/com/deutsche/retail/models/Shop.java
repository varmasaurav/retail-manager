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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (shopName != null ? !shopName.equals(shop.shopName) : shop.shopName != null) return false;
        return shopAddress != null ? shopAddress.equals(shop.shopAddress) : shop.shopAddress == null;

    }

    @Override
    public int hashCode() {
        int result = shopName != null ? shopName.hashCode() : 0;
        result = 31 * result + (shopAddress != null ? shopAddress.hashCode() : 0);
        return result;
    }


    public static class ShopAddress {
        private String number;
        private int postCode;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ShopAddress that = (ShopAddress) o;

            if (postCode != that.postCode) return false;
            return number != null ? number.equals(that.number) : that.number == null;

        }

        @Override
        public int hashCode() {
            int result = number != null ? number.hashCode() : 0;
            result = 31 * result + postCode;
            return result;
        }

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
