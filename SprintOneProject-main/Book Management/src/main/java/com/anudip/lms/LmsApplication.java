package com.anudip.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = { UserDetailsServiceAutoConfiguration.class })
public class LmsApplication {

    public static void main(String[] args) {
    	
        SpringApplication.run(LmsApplication.class, args);
    }
}
