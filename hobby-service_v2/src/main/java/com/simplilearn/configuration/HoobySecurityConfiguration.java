//package com.simplilearn.configuration;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//
//public class HoobySecurityConfiguration extends WebSecurityConfiguration {
//
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/admin/**").hasRole("Admin")
//				.antMatchers("/users/**").permitAll().and().httpBasic();
//		httpSecurity.csrf().disable();
//	}
//}
