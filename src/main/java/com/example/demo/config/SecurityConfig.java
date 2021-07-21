/*
 * package com.example.demo.config;
 * 
 * import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * public class SecurityConfig extends WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * 
 * auth.inMemoryAuthentication().withUser("user").password("password").roles(
 * "USER").and().withUser("admin") .password("password").roles("USER", "ADMIN");
 * 
 * auth.inMemoryAuthentication().withUser("omer").password("password").roles(
 * "ADMIN");
 * auth.inMemoryAuthentication().withUser("ziauddin").password("password").roles
 * ("PARENT"); }
 * 
 * }
 */