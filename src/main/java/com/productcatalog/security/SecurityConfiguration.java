package com.productcatalog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.productcatalog.service.CustomerUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	 @Autowired
	 private CustomerUserDetailsService userDetailsService;
	 
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	           System.out.println("SecurityConfiguration.configure() auth");
	        auth.userDetailsService(userDetailsService)
	        .passwordEncoder(getPasswordEncoder());
	    }


	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	    	System.out.println("SecurityConfiguration.configure() http");
	        http.csrf().disable();
	        http.authorizeRequests()
	                .antMatchers("/login1").hasAnyRole("ADMIN")
	                .anyRequest().permitAll()
	                .and()
	                .formLogin().defaultSuccessUrl("/login1")
	                .and().logout().logoutSuccessUrl("/")
	                .permitAll();
	    }

	    private PasswordEncoder getPasswordEncoder() {
	    	
	    	System.out.println("SecurityConfiguration.getPasswordEncoder() encode");
	        return new PasswordEncoder() {
	            @Override
	            public String encode(CharSequence charSequence) {
	                return charSequence.toString();
	            }

	            @Override
	            public boolean matches(CharSequence charSequence, String s) {
	                return true;
	            }
	        };
	    }
	}