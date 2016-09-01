package com.company.retail.db;

import com.company.retail.models.ShopWithLocation;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple class to act as in-memory database
 * Holds an array of shops
 * Created by saurav on 29/8/16.
 */
public class ShopListHolder {
    @NotNull
    private List<ShopWithLocation> list_of_shops = Collections.synchronizedList(new ArrayList<ShopWithLocation>());

    public ShopWithLocation get(int index) {
        return list_of_shops.get(index);
    }

    public void add(ShopWithLocation shopWithLocation) {
        list_of_shops.add(shopWithLocation);
    }

    public void remove(ShopWithLocation shopWithLocation) {
        list_of_shops.remove(shopWithLocation);
    }

    public void remove(int index) {
        list_of_shops.remove(index);
    }

    public List<ShopWithLocation> getAll() {
        return Collections.unmodifiableList(list_of_shops);
    }
}
