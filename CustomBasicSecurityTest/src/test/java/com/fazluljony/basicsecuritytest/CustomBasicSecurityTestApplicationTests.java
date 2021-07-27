package com.fazluljony.basicsecuritytest;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class CustomBasicSecurityTestApplicationTests {

	@Test
	void contextLoads() {
		
		System.out.println(new BCryptPasswordEncoder().encode("jony"));
		System.out.println(new Pbkdf2PasswordEncoder().encode("jony"));
		System.out.println(new SCryptPasswordEncoder().encode("jony"));
		
		Map<String , PasswordEncoder> endocers = new HashMap<>();
		endocers.put("bcrypt", new BCryptPasswordEncoder());
		endocers.put("scrypt", new SCryptPasswordEncoder());
		
		System.out.println(new DelegatingPasswordEncoder("bcrypt", endocers).encode("jony"));
		System.out.println(new DelegatingPasswordEncoder("scrypt", endocers).encode("jony"));
	}

}
