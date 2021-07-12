package com.dio.sawcunha.beercontrol.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "application")
@Configuration("beer_control_properties")
@Data
public class BeerControlProperties {

    private String description;
    private String version;
    private String msg_success;
    private String msg_warehouse_max_expect;
    private String base_package;
    private String api_title;
    private String api_description;
    private String contact_name;
    private String contact_git;
    private String contact_email;
    private String version_api;
}
