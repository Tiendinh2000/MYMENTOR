package com.Spring.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
	}

	@Autowired
	DataSource DataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").authenticated();
		http.csrf().disable().authorizeRequests().antMatchers("/homepage").permitAll()
			    .antMatchers("/user/**").permitAll()
				.and().formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("username").passwordParameter("password")
				.successHandler(authenticationSuccessHandler).failureUrl("/login?error=fail")
				.and().exceptionHandling().accessDeniedPage("/404")
				.and().logout().deleteCookies("JSESSIONID").logoutSuccessUrl("/user/login")
	            .and()
	            .rememberMe().rememberMeParameter("remember-me")
	            .key("uniqueAndSecret").tokenValiditySeconds(86400);


	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(DataSource)
				.usersByUsernameQuery("select username, password, enable from useraccount where username=?")
				.authoritiesByUsernameQuery("select username, role from useraccount where username=?");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/vendor/**","/assets/css/**");
	}


}
