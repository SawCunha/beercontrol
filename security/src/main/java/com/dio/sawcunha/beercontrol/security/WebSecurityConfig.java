package com.dio.sawcunha.beercontrol.security;

import com.dio.sawcunha.beercontrol.LogService;
import com.dio.sawcunha.beercontrol.exception.AccessDeniedExceptionHandler;
import com.dio.sawcunha.beercontrol.security.jwt.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = { "com.dio.sawcunha.beercontrol.controller" })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedExceptionHandler accessDeniedExceptionHandler;

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private LogService<WebSecurityConfig> webSecurityConfigLogService;

    @PostConstruct
    public void init(){
        webSecurityConfigLogService.init(WebSecurityConfig.class);
        webSecurityConfigLogService.logInfor("Init WebSecurityConfig");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests(auth -> auth
                        .antMatchers("/**").permitAll()
                        .antMatchers("/api/v1/**").denyAll()
                        .anyRequest().authenticated())
                .csrf()
                .disable()
                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                )
                .exceptionHandling().accessDeniedHandler(accessDeniedExceptionHandler);
        httpSecurity.headers().frameOptions().disable();
        httpSecurity.sessionManagement() // dont create a session for this configuration
                .sessionCreationPolicy(SessionCreationPolicy.NEVER);
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
    }

}
