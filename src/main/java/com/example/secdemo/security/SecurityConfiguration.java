package com.example.secdemo.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	private final PasswordEncoder passwordEncoder;
	private UserDetailsService userDetailsService;

	public SecurityConfiguration(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
		this.passwordEncoder = passwordEncoder;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		  .passwordEncoder(this.passwordEncoder);
//		  .inMemoryAuthentication()
//		  .withUser("security.com")
//		  .password(this.passwordEncoder.encode("123test"))
//		  .roles("USER" , "MANAGER");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN")
		.anyRequest().hasAnyRole("USER").and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/")
		.permitAll();
	}
	
	

}
