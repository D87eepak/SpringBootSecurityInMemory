package com.spring.boot.basic.auth.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	/***
	 * We can give config level Authorization, and at method Level with @PreAuhtorize("hasRole('ADMIN')")
	 * If we enter the correct password but we have not the permission/authority for the method it will return status code 403.
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/employee/name/**","/employee/search/**").permitAll()    // url from the root is required to provide
			
			//.antMatchers("/employee/account/*").hasRole("ADMIN").anyRequest().authenticated()
			.antMatchers("/employee/account/*").authenticated()
			.and()
				.formLogin().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403");
			
		
	}
	@Override
	public void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("admin").password("admin").roles("ADMIN")
			.and()
			.withUser("user").password("user").roles("USER");
	}

}
