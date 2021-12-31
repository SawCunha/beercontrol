package com.dio.sawcunha.beercontrol;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.dio.sawcunha.beercontrol"})
@ConfigurationPropertiesScan(basePackages ={"com.dio.sawcunha.beercontrol"})
@ComponentScan(basePackages ={"com.dio.sawcunha.beercontrol"})
@AutoConfigurationPackage
@AutoConfigureOrder
@EnableAsync
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerControlApplication {

    private Environment properties;

    public static void main(String[] args) {
        SpringApplication.run(BeerControlApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(10); //reload messages every 10 seconds
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

}
