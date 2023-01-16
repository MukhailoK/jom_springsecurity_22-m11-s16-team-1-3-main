package com.softserve.itacademy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class WebSecurityConfigurer {

    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("user1")
                .passwordParameter("1111")
                .loginPage("/login-form")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .failureUrl("login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/perform-logout")
                .logoutSuccessUrl("/login-form")
                .deleteCookies("JSESSIONID");
    }

//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mySql://localhost:3306/spring-security-db");
//        dataSource.setUsername("root");
//        dataSource.setPassword("1111");
//        return dataSource;
//    }
}
