package com.dio.sawcunha.beercontrol.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Arrays;

//@Configuration
//@EnableCaching
public class CachingConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("auth"),
                new ConcurrentMapCache("beer")));
        return cacheManager;
    }

    @CacheEvict(allEntries = true, value = {"auth"})
    @Scheduled(fixedDelay = 3600000 ,  initialDelay = 500)
    public void reportCacheEvict() {
        System.out.println("Flush Cache " + LocalDateTime.now());
    }
}
