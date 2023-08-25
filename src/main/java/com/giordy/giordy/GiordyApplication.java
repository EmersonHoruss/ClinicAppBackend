package com.giordy.giordy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class GiordyApplication {
	public static void main(String[] args) {
		SpringApplication.run(GiordyApplication.class, args);
	}
}
