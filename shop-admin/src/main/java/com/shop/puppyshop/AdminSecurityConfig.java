package com.shop.puppyshop;

import com.shop.puppyshop.config.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/admin/login")
                .defaultSuccessUrl("/admin")
                .usernameParameter("userId")
                .failureUrl("/admin/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
                .logoutSuccessUrl("/");
        http.csrf().disable();

        http.authorizeRequests()
                .mvcMatchers("/").access("hasIpAddress('0:0:0:0:0:0:0:1')")
                        .mvcMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated();


        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint());
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/img/**");
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
