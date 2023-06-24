package com.nutrition.information.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	// @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public InMemoryUserDetailsManager userDetails() {

		UserDetails p1 = User.builder().username("p1").password("{noop}p1").roles("USER").build();
		UserDetails p2 = User.builder().username("p2").password("{noop}p2").roles("ADMIN", "MANAGER").build();

		return new InMemoryUserDetailsManager(p1, p2);
	}

	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/assets/**", "/", "/Home", "/About");
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.authorizeHttpRequests(configurator -> configurator.requestMatchers("/Units/Create")
				.hasRole("ADMIN")
				.requestMatchers("/Units/Edit/**")
				.hasRole("ADMIN")
				.requestMatchers("/Units/Delete/**")
				.hasRole("ADMIN")
				.requestMatchers("Units/All")
				.hasAnyRole("USER", "ADMIN")
				.anyRequest()
				.authenticated())
			.exceptionHandling(config -> config.accessDeniedPage("/AccessDenied"))
			.formLogin(form -> form.loginPage("/Login")
				.loginProcessingUrl("/authenticate")
				.defaultSuccessUrl("/Home")
				.permitAll())
			.logout(LogoutConfigurer::permitAll)
			.httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
	}

}