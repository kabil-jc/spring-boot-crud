package com.example.spring_boot_demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http){
    http.authorizeHttpRequests(authz->authz.requestMatchers("/api/users/**").authenticated()
                  //  .requestMatchers("/").permitAll()
                    .requestMatchers(HttpMethod.POST,"/api/users").permitAll()
                    .anyRequest().permitAll()

            ).formLogin(form->form.permitAll().defaultSuccessUrl("/dashboard"))
            .csrf(csrf-> csrf.disable())
    ;
     return http.build();
}
@Bean
public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
    UserDetails user = User.withUsername("naveen")
            .password(passwordEncoder.encode("user123"))
            .roles("trader")
            .build();
    UserDetails admin = User.withUsername("jack")
            .password(passwordEncoder.encode("admin123"))
            .roles("admin")
            .build();
    return new InMemoryUserDetailsManager(user,admin);
}
@Bean
public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}
}
