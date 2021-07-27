package com.fazluljony.basicsecuritytest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfigure extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		InMemoryUserDetailsManager userdetailservice = new InMemoryUserDetailsManager();
		
		UserDetails user = User.withUsername("jony")
				.password(passwordEncoder.encode(("eraFariha")))
				.authorities("read").build();
		
		userdetailservice.createUser(user);
		auth.userDetailsService(userdetailservice)
		.passwordEncoder(passwordEncoder);
		
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.httpBasic();
		//http.authorizeRequests().anyRequest().permitAll();
		http.authorizeRequests().antMatchers("/api").authenticated();
		//http.authorizeRequests().antMatchers("/api","/manage","/test").authenticated();
		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
	}

}
