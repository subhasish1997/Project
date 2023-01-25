package com.anudip.lms.security;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.anudip.lms.authentication.AdminDetails;

@Configuration
public class SecurityConfiguration {
	
    private final Map<String, String> admins;
    
    public SecurityConfiguration() {
        this.admins = AdminDetails.getAdmins();
    }

    @Bean
    @Primary
    AuthenticationManagerBuilder configure(AuthenticationManagerBuilder auth) throws Exception {
        for (Map.Entry<String, String> entry : admins.entrySet()) {
            String username = entry.getKey();
            String password = entry.getValue();
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username(username)
                    .password(password)
                    .roles("ADMIN")
                    .build();
            auth.inMemoryAuthentication().withUser(user);
        }
        return auth;
    }
}
