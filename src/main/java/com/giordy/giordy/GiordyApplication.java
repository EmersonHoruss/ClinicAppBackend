package com.giordy.giordy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GiordyApplication {
	public static void main(String[] args) {
		SpringApplication.run(GiordyApplication.class, args);
	}
}
