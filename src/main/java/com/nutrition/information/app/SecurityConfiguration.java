package com.nutrition.information.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public InMemoryUserDetailsManager userDetails() {
		
		UserDetails p1 = User.builder().username("p1").password("{noop}p1").roles("USER").build();
		UserDetails p2 = User.builder().username("p2").password("{noop}p2").roles("ADMIN", "MANAGER").build();
		
		return new InMemoryUserDetailsManager(p1, p2);
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeHttpRequests(configurer ->
		configurer
		.requestMatchers("/Units/Create").hasRole("ADMIN")
		.requestMatchers("/Units/Edit/**").hasRole("ADMIN")
		.requestMatchers("/Units/Delete/**").hasRole("ADMIN")
		.requestMatchers("Units/All").hasAnyRole("USER","ADMIN")
		.anyRequest().authenticated()
			)
		.formLogin(form->
		form
		.loginPage("/Login")
		.loginProcessingUrl("/authenticate")
		.permitAll()
		)
		.logout(logout->logout.permitAll()
		);
	return httpSecurity.build();
	} 
	// you can either do this or add it to the configurator
	//@Bean
    //public WebSecurityCustomizer webSecurityCustomizer() {
    //    return (web) -> web.ignoring().requestMatchers("/Home","/Home/**");
    //}
}
