package com.example.WebSite.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.WebSite.Repository.UserRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	UserRepository userepo;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request -> request
                .requestMatchers("/css/**", "/js/**", "/lib/**", "/img/**").permitAll()
                .requestMatchers("/admin/","/admin/**").authenticated()
                .requestMatchers("/*", "/styles/*", "/login").permitAll()
                .anyRequest().authenticated())
        	.formLogin(form -> form.defaultSuccessUrl("/", true)
                .permitAll())
        	.logout(LogoutConfigurer::permitAll);
		return http.build();
	}
    
    @Bean
	PasswordEncoder passwordEncoder() { 
		 return new BCryptPasswordEncoder(); 
	}

    @Bean
    UserDetailsService userDetailsService() {
		    return username -> userepo.findByEmail(username)
		        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception { 
		 AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		 authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder()); 
		 return authenticationManagerBuilder.build(); 
	}
    
}
