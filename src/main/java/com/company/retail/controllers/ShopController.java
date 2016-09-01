package com.company.retail.controllers;

import com.company.retail.exception.RetailManagerServiceException;
import com.company.retail.main.Messages;
import com.company.retail.models.Location;
import com.company.retail.models.ServiceResponse;
import com.company.retail.models.Shop;
import com.company.retail.service.shop.ShopLocatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller class for all shop related requests
 * Created by saurav on 28/8/16.
 */
@RestController
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    public void setShopLocatorService(ShopLocatorService shopLocatorService) {
        this.shopLocatorService = shopLocatorService;
    }

    @Autowired
    ShopLocatorService shopLocatorService;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/")
    public String status() {
        return Messages.APP_SUCCESS;
    }

    @RequestMapping(path = "/addShop", method = RequestMethod.POST)
    public String addShop(HttpServletRequest request, @Validated @RequestBody Shop shop){
        String response;

        try {
            shopLocatorService.save(shop);
            response = objectMapper.writeValueAsString(new ServiceResponse(true));
        } catch (IOException io) {
            logger.error("Error while processing input during addShop", io);
            throw new RetailManagerServiceException(io, Messages.RESPONSE_NOT_PROCESSED, HttpStatus.OK);
        }
        return response ;
    }

    @RequestMapping(path = "/nearestShop", method = RequestMethod.GET)
    public String getNearestShop(@RequestParam("customerLongitude") String latitude,
                                           @RequestParam("customerLongitude") String longitude) {
        String result = null;
        try {
            Location location = new Location(Double.parseDouble(latitude), Double.parseDouble(longitude));
            result = objectMapper.writeValueAsString(shopLocatorService.nearest(location));
            return result;
        } catch (NumberFormatException e) {
            logger.error("Invalid value for longitude - " + longitude + " or latitude - " + latitude, e);
            throw new RetailManagerServiceException(e, Messages.INVALID_LOCATION, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Error getting nearest shop for location - (" + latitude + ", " +longitude + ")" , e);
            throw new RetailManagerServiceException(e, Messages.SERVICE_UNAVAILABLE, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    /**
     * Exception handling at controller level.
     * @param e
     * @param response
     * @return
     */
    // Use @ControlAdvice for Global Exception handling
    @ExceptionHandler(value = RetailManagerServiceException.class)
    public String handler(RetailManagerServiceException e, HttpServletResponse response) {
        response.setStatus(e.getHttpStatusCode().value());
        return e.getMessage();
    }
}
