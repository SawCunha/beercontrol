package com.dio.sawcunha.beercontrol.scheduled.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@DependsOn(value = {"TaskProperties"})
public class TaskConfig {

    @Autowired
    private ScheduledPropertiesConfig.TaskProperties taskProperties;

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(taskProperties.getCorePoolSize());
        executor.setMaxPoolSize(taskProperties.getMaxPoolSize());
        executor.setQueueCapacity(taskProperties.getQueueCapacity());
        executor.setThreadNamePrefix(taskProperties.getThreadNamePrefix());
        executor.initialize();
        return executor;
    }

}
