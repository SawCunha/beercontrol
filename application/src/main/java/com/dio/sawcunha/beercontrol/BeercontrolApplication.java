package com.dio.sawcunha.beercontrol;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication(scanBasePackages = {"com.dio.sawcunha.beercontrol"})
@ConfigurationPropertiesScan(basePackages ={"com.dio.sawcunha.beercontrol"})
@AutoConfigurationPackage
@EnableScheduling
@EnableAsync
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeercontrolApplication {

    private Environment properties;

    public static void main(String[] args) {
        SpringApplication.run(BeercontrolApplication.class, args);
    }

//    @Bean
//    public Executor taskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(properties.getProperty("task.corePoolSize",Integer.class));
//        executor.setMaxPoolSize(properties.getProperty("task.maxPoolSize",Integer.class));
//        executor.setQueueCapacity(properties.getProperty("task.queueCapacity",Integer.class));
//        executor.setThreadNamePrefix(properties.getProperty("task.threadNamePrefix",String.class));
//        executor.initialize();
//        return executor;
//    }

}
