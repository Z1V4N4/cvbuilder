package com.batm.cvbuilder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    private JWTAuthFilter jwtAuthFilter;

    // authentication
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // httpSecurity.csrf().disable().authorizeHttpRequests((auth) -> {
        // try {
        // auth.antMatchers("/api/department/**").hasAuthority("Staff")
        // .antMatchers("/api/region/**").authenticated()
        // .antMatchers("/api/user/**").permitAll()
        // .anyRequest().authenticated()
        // .and()
        // .sessionManagement()
        // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        // .and()
        // .authenticationProvider(authenticationProvider())
        // .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        // } catch (Exception e) {
        // throw new RuntimeException(e);
        // }
        // });
        // return httpSecurity.build();

        httpSecurity.authorizeHttpRequests().anyRequest().permitAll();
        return httpSecurity.build();
    }

    // hashing
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetails();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
