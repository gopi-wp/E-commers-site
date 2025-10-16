package com.example.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.*;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.model.User;

@Configuration
public class SecurityConfig {

  private final UserRepository userRepo;
  public SecurityConfig(UserRepository ur) { this.userRepo = ur; }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable()) // for demo simplicity; enable in production
      .authorizeHttpRequests(auth -> auth
         .requestMatchers("/","/index.html","/static/**","/login.html","/css/**","/js/**","/api/products/**").permitAll()
         .anyRequest().authenticated()
      )
      .formLogin(form -> form
         .loginPage("/login.html")
         .loginProcessingUrl("/perform_login")
         .defaultSuccessUrl("/", true)
         .permitAll()
      )
      .logout(logout -> logout.logoutUrl("/perform_logout").logoutSuccessUrl("/"));

    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> {
      User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
      return User.withUsername(user.getUsername())
                 .password(user.getPassword())
                 .roles(user.getRole().replace("ROLE_", ""))
                 .build();
    };
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
