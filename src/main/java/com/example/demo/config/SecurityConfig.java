
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// only url based security ie every url will be authenticated
	// if u r not configuring any usernam password then u can use token generated in
	// console as password
	// and username as user
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("omer").password("password").roles("ADMIN");
	}

	// method in which we want to implement security
	// only url based security ie every url will be authenticated ie for all api
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	}
	// bs password wants password in encode form in configure method thats why
	// providing password bean
	// Bcrypt bean can also be provided
	// but will not work as it will not be able to match password in bcrypt matches
	// method

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	/*
	 * @Bean public PasswordEncoder encoder() { return new BCryptPasswordEncoder();
	 * }
	 */

}
