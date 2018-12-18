package com.change.pet;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zhaochangzhi
 * @description
 * @date 2018/10/9 14:59
 */
@Configuration
public class ChangePetSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeRequests()
        .antMatchers("/order", "/index").permitAll();
    httpSecurity.csrf().disable();
    //	super.configure(httpSecurity);
  }
}