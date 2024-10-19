package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringConfig {
 
    @Bean
    public InMemoryUserDetailsManager userDetailService(){
        UserDetails userDetail = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN",
                "USER").build();
        UserDetails userDetail1 = User.withDefaultPasswordEncoder().username("admin123").password("admin123").roles(
                "ADMIN","USER").build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(userDetail,userDetail1);
        return inMemoryUserDetailsManager;
    }
}
