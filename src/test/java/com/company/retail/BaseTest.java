package com.company.retail;

import com.company.retail.db.ShopListHolder;
import com.company.retail.service.shop.ShopLocatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by saurav on 1/9/16.
 */
@ContextConfiguration({"/test-spring-context.xml"})
public class BaseTest {

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected ShopLocatorService shopLocatorService;

    @Autowired
    protected ShopListHolder shopListHolder;

}
