package com.demo.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.demo.Model.RoleEnum;

@EnableWebSecurity
@Deprecated
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    DataSource dataSource;

    // @Autowired
    // BCryptPasswordEncoder encoder;

    @Autowired
    UserDetailsService userDetailServiceImpl;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        // for h2 access
        http.csrf().ignoringAntMatchers("/h2-console/**");
        http.headers().frameOptions().disable();

        http
            .authorizeRequests()
                .antMatchers("/", "/h2-console/**").permitAll()
                .antMatchers("/home/manager*").hasAuthority("ROLE_MANAGER")
                .antMatchers("/**").fullyAuthenticated()
            .and()
            .formLogin().loginPage("/")
            .usernameParameter("email").passwordParameter("password")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/home/all", true)
            .failureUrl("/accessDenied")
            .and()
            .logout().logoutUrl("/logout")
            .logoutSuccessUrl("/");
        
    
        
            
    }
}
