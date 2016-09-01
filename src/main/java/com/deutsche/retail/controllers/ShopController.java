package com.deutsche.retail.controllers;

import com.deutsche.retail.models.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

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
