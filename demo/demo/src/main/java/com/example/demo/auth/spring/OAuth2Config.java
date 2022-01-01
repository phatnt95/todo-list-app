package com.example.demo.auth.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class OAuth2Config extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.cors()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "api/**")
                .hasAuthority("SCOPE_read")
                .antMatchers(HttpMethod.POST, "api/**")
                .hasAuthority("SCOPE_write")
                .anyRequest().authenticated().and()
                .oauth2ResourceServer()
                .jwt();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
