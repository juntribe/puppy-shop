package com.shop.puppyshop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig{




    @Order(0)
    @Configuration
    public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/admin/**")
                            .formLogin()
                            .loginPage("/admin/login")
                            .usernameParameter("userId")
                            .defaultSuccessUrl("/admin")
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
            web.ignoring().antMatchers("/**/*.css","/**/*.js","/**/fonts/*","/**/img/**","/**/images/**","/**/*.map","/favicon.ico");
        }

    }

    @Order(1)
    @Configuration
    public class UserSecurityConfig extends WebSecurityConfigurerAdapter {



        @Override
        protected void configure(HttpSecurity http) throws Exception {

        http.antMatcher("/**")
                .formLogin().loginPage("/members/login")
                .defaultSuccessUrl("/")
                .usernameParameter("userId")
                .failureUrl("/members/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);

        http.csrf().disable();



        }


        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/**/*.css","/**/*.js","/**/fonts/*","/**/img/**","/**/images/**","/**/*.map","/favicon.ico");
        }


    }







    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
