package com.demo.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.demo.Model.RoleEnum;

@EnableWebSecurity
@Deprecated
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    DataSource dataSource;

    // @Autowired
    // BCryptPasswordEncoder encoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // String encoded = encoder.encode("password");
        // System.out.println("encoded:::::::::::::::"+encoded);

        auth.jdbcAuthentication().dataSource(dataSource)
            .passwordEncoder(encoder)
            .usersByUsernameQuery("select email, password, 'true' as enabled from company_user where email=?")
            .authoritiesByUsernameQuery("select email, user_role, 'true' as enabled from company_user where email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        // for h2 access
        http.csrf().disable();
        http.headers().frameOptions().disable();

        //
        http
            .authorizeRequests()
                .antMatchers("/", "/h2-console/**").permitAll()
                // .antMatchers("/manager*").hasAuthority("MANAGER")
                .antMatchers("/**").fullyAuthenticated()
            .and()
            .formLogin().loginPage("/")
            .usernameParameter("email").passwordParameter("password")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/home", true)
            .failureUrl("/accessDenied")
            .and()
            .logout().logoutUrl("/logout")
            .logoutSuccessUrl("/");
        
    
        
            
    }
}
