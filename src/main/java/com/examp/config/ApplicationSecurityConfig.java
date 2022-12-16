package com.examp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfig {
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 
		 http.csrf().disable();
		 http.cors().disable();
		 http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.oauth2ResourceServer().jwt();
			
	        return http.build();
	    }
	 
	 @Bean
	 public JwtAuthenticationConverter jwtAuthConverter() {
		 JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		 JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		 jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("groups");
		 jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
		 jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
		 
		 return jwtAuthenticationConverter;
		 
	 }

}
