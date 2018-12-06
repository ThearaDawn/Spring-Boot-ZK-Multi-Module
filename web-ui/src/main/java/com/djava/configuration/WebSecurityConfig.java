package com.djava.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * This is an example of minimal configuration for ZK + Spring Security, we open as less access as possible to run a ZK-based application.
 * Please understand the configuration and modify it upon your requirement.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 private static final String ZUL_FILES = "/zkau/web/**/*.zul";
	    private static final String[] ZK_RESOURCES = {"/zkau/web/**/js/**", "/zkau/web/**/zul/css/**", "/zkau/web/**/img/**"};
	    private static final String[] WEBJAR = {"/webjars/**"};
	    private static final String[] STATIC_RESOURCES = {"/css/**", "/js/**", "/img/**"};
	    private static final String[] PUBIC_PAGE = {"/login", "logout", "/**", "/h2-console/**", "/console/**", "/register"};
	    
	    // allow desktop cleanup after logout or when reloading login page
	    private static final String REMOVE_DESKTOP_REGEX = "/zkau\\?dtid=.*&cmd_0=rmDesktop&.*";

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        // ZK already sends a AJAX request with a built-in CSRF token,
	        // please refer to https://www.zkoss.org/wiki/ZK%20Developer's%20Reference/Security%20Tips/Cross-site%20Request%20Forgery
	        http.csrf().disable();
	        http.headers().frameOptions().disable();
	        http.authorizeRequests()
	            .antMatchers(ZUL_FILES).denyAll() // block direct access to zul files
	            .antMatchers(HttpMethod.GET, ZK_RESOURCES).permitAll() // allow zk resources
	            .antMatchers(HttpMethod.GET, WEBJAR).permitAll()
	            .antMatchers(PUBIC_PAGE).permitAll()
	            .antMatchers(HttpMethod.GET, STATIC_RESOURCES).permitAll()
	            .regexMatchers(HttpMethod.GET, REMOVE_DESKTOP_REGEX).permitAll() // allow desktop cleanup
	            .mvcMatchers("/","/login","/logout").permitAll()
	            .mvcMatchers("/secure").hasRole("USER")
	            .anyRequest().authenticated()
	            .and()
	            .formLogin()
	            .loginPage("/login").defaultSuccessUrl("/secure/main")
	            .and()
	            .logout().logoutUrl("/logout").logoutSuccessUrl("/");
	    }

	    @Bean
	    @Override
	    public UserDetailsService userDetailsService() {
	        UserDetails user =
	                User.withDefaultPasswordEncoder()
	                        .username("user")
	                        .password("password")
	                        .roles("USER")
	                        .build();

	        return new InMemoryUserDetailsManager(user);
	    }
}