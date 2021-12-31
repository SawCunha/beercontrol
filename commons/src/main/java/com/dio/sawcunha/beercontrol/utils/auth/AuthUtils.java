package com.dio.sawcunha.beercontrol.utils.auth;

import org.springframework.util.DigestUtils;

public class AuthUtils {

    private static final String SALT = "BIC";

    public static String encryptPassword(String password){
        return DigestUtils
                .md5DigestAsHex(String.format("%s%s",password,SALT).getBytes()).toUpperCase();
    }

}
