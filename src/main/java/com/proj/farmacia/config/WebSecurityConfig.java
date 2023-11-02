
package com.proj.farmacia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests((requests) -> requests
            //.requestMatchers("/funcionarios", "/home").permitAll()
            //.anyRequest().authenticated()
            .anyRequest().permitAll()
        )
        .csrf((requests) -> requests.disable())
        .httpBasic((requests) -> requests.disable());
        // .formLogin((form) -> form
        //     .loginPage("/login")
        //     .permitAll()
        // )
        // .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}