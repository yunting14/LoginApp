// package com.demo.Security;

// import javax.annotation.Resource;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration {

//     private UserDetailServiceImpl userDetailServiceImpl;
    
//     public SecurityConfiguration(UserDetailServiceImpl userDetailServiceImpl){
//         this.userDetailServiceImpl = userDetailServiceImpl;
//     }

//     @Bean
//     protected SecurityFilterChain configure (HttpSecurity httpSecurity) throws Exception{
//         httpSecurity.authorizeRequests().antMatchers("/").permitAll()
//         .and().authorizeRequests().antMatchers("/console/**").permitAll()
//         .and()
//         .formLogin()
//         .loginPage("/")
//         .permitAll()
//         .defaultSuccessUrl("/welcome", true)
//         .and()
//         .logout()
//         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        
//         httpSecurity.csrf().disable();
        
//         httpSecurity.headers().frameOptions().disable();
        
//         return httpSecurity.build();
//     }

//     @Bean
//     public AuthenticationProvider daoAuthenticationProvider() {
//         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//         provider.setPasswordEncoder(passwordEncoder());
//         provider.setUserDetailsService(userDetailServiceImpl);
//         return provider;
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }

// /*
// https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/
// https://www.appsdeveloperblog.com/add-h2-database-to-spring-boot-project-with-spring-security/
// *** Take h2-console out of Spring Security’s authorization

// If you’ve enabled Spring Security in your Spring Boot application, you will not be able to access the H2 database console. With its default settings under Spring Boot, Spring Security will block access to H2 database console.

// To enable access to the H2 database console under Spring Security you need to change three things:

// Allow all access to the url path /console/*.
// Disable CRSF (Cross-Site Request Forgery). By default, Spring Security will protect against CRSF attacks.
// Since the H2 database console runs inside a frame, you need to enable this in in Spring Security.
// The following Spring Security Configuration will:

// Allow all requests to the root url (“/”) (Line 12)
// Allow all requests to the H2 database console url (“/console/*”) (Line 13)
// Disable CSRF protection (Line 15)
// Disable X-Frame-Options in Spring Security (Line 16)
//  */
