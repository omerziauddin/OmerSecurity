
package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public PasswordEncoder encoder;

	// implement security for specific controller not for other controllers by using
	// url based security
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("omer").password(encoder.encode("password")).roles("ADMIN");

	}
	// method in which we want to implement security
	// not every url will be authenticated only specific urls will be authentiated

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().httpBasic();
	}
	
	// for urls having start with /rest only those urls will be authenticated else not
	//http://localhost:8080/noAuth/sayHi     in postman use no auth while executing this
	//http://localhost:8080/rest/auth/getMsg    in postman use basic auth while executing this and enter usernae paswrd


	// excpect password in encrypted format see matches method in this class
	// thats why encoding password using encoder.encode from Password Encoder class

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
