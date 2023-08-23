package com.bitnine.assessment.tsietsimaboa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.bitnine.assessment.tsietsimaboa.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Lazy
	@Autowired
	private UserService user_service;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		
		auth.setUserDetailsService(user_service);
		auth.setPasswordEncoder(passwordEncoder());
		
		return auth;
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))
		.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(
						AntPathRequestMatcher.antMatcher("/registration/**"),
						AntPathRequestMatcher.antMatcher("/h2-console/**"),
						AntPathRequestMatcher.antMatcher("/js/**"), 
						AntPathRequestMatcher.antMatcher("/css/**"), 
						AntPathRequestMatcher.antMatcher("/fonts/**"), 
						AntPathRequestMatcher.antMatcher("/scss/**"), 
						AntPathRequestMatcher.antMatcher("/images/**")).permitAll()
				.requestMatchers(AntPathRequestMatcher.antMatcher("/user/**")).hasAuthority("USER_ROLE")
				.anyRequest().authenticated())
		
		.formLogin(formLogin -> formLogin
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.failureUrl("/login?error")
				.permitAll())
		
		.logout(logout -> logout
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll())
		
		.headers(headers -> headers.frameOptions(frameOptions -> frameOptions
				.sameOrigin()));
		
		return http.build();
	}
}
