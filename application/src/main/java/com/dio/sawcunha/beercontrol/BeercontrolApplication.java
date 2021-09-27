package com.dio.sawcunha.beercontrol;

import com.dio.sawcunha.beercontrol.scheduled.ScheduledModel;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Properties;
import java.util.concurrent.Executor;

@SpringBootApplication(scanBasePackages = {"com.dio.sawcunha.beercontrol"})
@ConfigurationPropertiesScan(basePackages ={"com.dio.sawcunha.beercontrol"})
@AutoConfigurationPackage
@EnableScheduling
@EnableAsync
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeercontrolApplication {

    private Environment properties;
    private static final Logger log = LoggerFactory.getLogger(BeercontrolApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BeercontrolApplication.class, args);
    }

    @Bean
    @ConditionalOnProperty(
            name = "task.ativo", havingValue = "true")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(properties.getProperty("task.corePoolSize",Integer.class));
        executor.setMaxPoolSize(properties.getProperty("task.maxPoolSize",Integer.class));
        executor.setQueueCapacity(properties.getProperty("task.queueCapacity",Integer.class));
        executor.setThreadNamePrefix(properties.getProperty("task.threadNamePrefix",String.class));
        executor.initialize();
        return executor;
    }

    @Bean
    @ConditionalOnProperty(
            name = "spring.mail.ativo",
            matchIfMissing = true,
            havingValue = "false")
    public JavaMailSender getJavaMailSenderDefault() {
        log.info("Default email configuration");
        return new JavaMailSenderImpl();
    }

    @Bean
    @ConditionalOnProperty(name = "spring.mail.ativo", havingValue = "true")
    public void javaMailSenderConfigurationProperties() {
        System.out.println("Email configuration defined in properties");
    }

}
