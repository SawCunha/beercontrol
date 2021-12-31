package com.dio.sawcunha.beercontrol.scheduled.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Configuration
@EnableScheduling
@PropertySource(value = "classpath:scheduled_properties.properties")
public class ScheduledPropertiesConfig {

    @Bean(name = "ScheduledProperties")
    public ScheduledProperties getScheduledProperties() {
        return new ScheduledProperties();
    }

    @Bean(name = "TaskProperties")
    public TaskProperties getScheduledTaskProperties() {
        return new TaskProperties();
    }

    @Validated
    @Data
    public static class ScheduledProperties {

        @NotEmpty
        @Value("${scheduled.defaultTime}")
        private Long defaultTime;
        @NotEmpty
        @Value("${scheduled.notificationTime}")
        private Long notificationTime;
        @NotEmpty
        @Value("${scheduled.movementTime}")
        private Long movementTime;
    }

    @Validated
    @Data
    public static class TaskProperties {

        @NotEmpty
        @Value("${scheduled.task.corePoolSize}")
        private Integer corePoolSize;
        @NotEmpty
        @Value("${scheduled.task.maxPoolSize}")
        private Integer maxPoolSize;
        @NotEmpty
        @Value("${scheduled.task.queueCapacity}")
        private Integer queueCapacity;
        @NotEmpty
        @Value("${scheduled.task.threadNamePrefix}")
        private String threadNamePrefix;

    }

}
