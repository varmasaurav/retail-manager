package com.deutsche.retail.controllers;

import com.deutsche.retail.main.Messages;
import com.deutsche.retail.models.Shop;
import com.deutsche.retail.service.shop.ShopLocatorService;
import com.deutsche.retail.service.shop.ShopLocatorServiceImpl;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * Created by saurav on 28/8/16.
 */
@RestController
public class ShopController {

    @RequestMapping("/")
    public String status(@RequestHeader("Accept-Language") Locale locale) {
        return Messages.APP_SUCCESS;
    }
}
