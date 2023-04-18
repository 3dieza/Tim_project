package com.bank.antifraud.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
////                .antMatchers(HttpMethod.PUT, "/api/anti-fraud/audits").authenticated() // разрешаем аутентифицированный доступ к PUT запросу
//                .antMatchers("/api/anti-fraud/**").authenticated()
//                .antMatchers("/audits", "/audits/**").permitAll()
//                .and()
//                .httpBasic();
                .antMatchers("/**").permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("users")
                .password("{noop}password")
                .roles("USER");
    }
}

