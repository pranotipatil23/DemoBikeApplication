package com.bike.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.bike.demo.service.DemoService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.bike.demo"})
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private DemoService service;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, "--debug");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SecurityContextHolder.getContext()
		.setAuthentication(new UsernamePasswordAuthenticationToken("user", "N/A",
				AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")));
		try {
			System.out.println(this.service.secure());
		}
		finally {
			SecurityContextHolder.clearContext();
		}
	}

}
