package com.fazluljony.basicsecuritytest;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String UserName = authentication.getName();
		String password = authentication.getCredentials().toString();
		if("jony".equals(UserName)&&"eraFriha".equals(password))
		{
			return new UsernamePasswordAuthenticationToken(UserName, password, Arrays.asList());
		}
		else
		{
			throw new BadCredentialsException("Wrong Username or Passwword or both");
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class) ;
	}

}
