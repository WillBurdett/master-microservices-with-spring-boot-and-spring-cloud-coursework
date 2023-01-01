package com.in28minutes.rest.webservices.restfulwebservices.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1. all requests must be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // 2. If a request is not authenticated, a web page is shown (with a pop-up for login)
        http.httpBasic(withDefaults());

        // 3. CSRF -> POST, PUT
        http.csrf().disable();


        return http.build();
    }
}
