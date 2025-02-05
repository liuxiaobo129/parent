//package com.sec.session;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/public").permitAll()  // 允许访问
//                        .requestMatchers("/admin").hasRole("USER1")  // 只有 ADMIN 角色可以访问
//                        .requestMatchers("/user").hasRole("USER")  // 只有 USER 角色可以访问
//                        .anyRequest().authenticated()  // 其他请求需要身份验证
//                )
//                .formLogin(Customizer.withDefaults()) // 启用默认的表单登录
//                .httpBasic(Customizer.withDefaults()); // 启用 HTTP Basic 认证
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("123456")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager();
//    }
//}