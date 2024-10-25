package com.scm.config;

import com.scm.ServicesImpl.SecurityUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringConfig {
 /*For the testing purpose*/
   /* @Bean
    public InMemoryUserDetailsManager userDetailService(){
        UserDetails userDetail = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN",
                "USER").build();
        UserDetails userDetail1 = User.withDefaultPasswordEncoder().username("admin123").password("admin123").roles(
                "ADMIN","USER").build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(userDetail,userDetail1);
        return inMemoryUserDetailsManager;
    }*/
    /*For production level*/
    @Autowired
    private SecurityUserDetailService securityUserDetailService;
    /*Configuration of authentication provider*/
    @Bean
    public AuthenticationProvider authencationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        //        user detail service ka object
        daoAuthenticationProvider.setUserDetailsService(securityUserDetailService);
//        password ka object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        configure the urls
        httpSecurity.authorizeHttpRequests(autherize->{
           /* autherize.requestMatchers("/home","/signup").permitAll();*/
            autherize.requestMatchers("/user/**").authenticated();
            autherize.anyRequest().permitAll();
        });
//        default form login
        /*httpSecurity.formLogin(Customizer.withDefaults());*/
//        with customize form login
        httpSecurity.formLogin(formLogin->{
           formLogin.loginPage("/login");
           formLogin.successForwardUrl("/user/dashboard");
           formLogin.failureForwardUrl("/login?error=true");
           formLogin.loginProcessingUrl("/authenticate");
           formLogin.usernameParameter("email");
           formLogin.passwordParameter("password");
        });
        return httpSecurity.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

}
