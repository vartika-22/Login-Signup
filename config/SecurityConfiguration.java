package com.registration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http	
				.formLogin(form-> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/")
				)
				.authorizeHttpRequests(auth-> auth
						
						.anyRequest().authenticated()
						)
//				.logout(logout->logout
//						.logoutSuccessUrl("/login?logout")
//				)
				.build();
	}
}
