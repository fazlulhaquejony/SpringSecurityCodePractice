package com.fazluljony.basicsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MyAuthenticationProvider authenticationProvider;
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
	//	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
	    
				UserDetails user = User.withUsername("jony")
			      .password(passwordEncoder.encode(("erafariha")))
			      .authorities("read")
			      .build();
		userDetailsService.createUser(user);
	auth.userDetailsService(userDetailsService);
	//.passwordEncoder(passwordEncoder);
	}
	*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.authenticationProvider(authenticationProvider);
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.formLogin();
		http.authorizeRequests().antMatchers("/api").authenticated();
	}  
	
	@Bean
	protected BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
