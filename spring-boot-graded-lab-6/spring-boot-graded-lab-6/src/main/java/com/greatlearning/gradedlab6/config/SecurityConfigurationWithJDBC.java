package com.greatlearning.gradedlab6.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity

public class SecurityConfigurationWithJDBC extends WebSecurityConfigurerAdapter {

	@Autowired
	
	DataSource dataSource;
	
	@Autowired
	
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
            .authoritiesByUsernameQuery("SELECT username, role FROM users WHERE username=?");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/", "/students/new").hasAnyAuthority("ADMIN", "USER")
		.antMatchers("/students/edit/{id}", "/students/{id}").hasAuthority("ADMIN")
		.antMatchers("/").permitAll().and().formLogin();
	}
}


