package com.company.retail.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by saurav on 1/9/16.
 */
//@Component
public class Config {

   // @Value("${geo.api.key}")
   // TODO: 29/8/16 Removing hard coding (read from file or db), Secret key should be encrypted
    public static String GEO_API_KEY = "AIzaSyCuJmJrMJvMzu_4ZgMpK7dJiV_26sBwBJ0";
}
