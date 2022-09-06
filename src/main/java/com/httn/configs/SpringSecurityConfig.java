/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.httn.handlers.LoginSuccessHandler;
import com.httn.handlers.LogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author HP
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.httn.controllers",
    "com.httn.repository",
    "com.httn.service",
    "com.httn.handlers"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private LoginSuccessHandler loginHandler;
    @Autowired
    private LogoutSuccessHandler logoutHanlder;


    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dkbtr8rbi",
            "api_key", "443275466499828",
            "api_secret", "etRgtPhSZDvgq4T-Y7B8PNuDRLM",
            "secure", true
        ));
        return c;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //edit v
        http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password");
        http.formLogin().successHandler(loginHandler);
        
        http.logout().logoutSuccessHandler(logoutHanlder);
        

        
        http.exceptionHandling().accessDeniedPage("/login?accessDenied");
        
//
        

        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/**/comments").authenticated()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/**/pay").authenticated();

        http.csrf().disable();
    }

}
