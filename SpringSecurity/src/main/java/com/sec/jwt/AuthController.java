package com.sec.jwt;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = new InMemoryUserDetailsManager(
                User.withUsername("admin").password("{noop}123456").roles("ADMIN").build(),
                User.withUsername("user").password("{noop}123456").roles("USER").build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest, HttpServletResponse response) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        if (!userDetails.getPassword().equals("{noop}" + authRequest.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }
        String token = jwtUtil.generateToken(userDetails.getUsername());
        // 将 token 放入 Authorization 头部
        response.setHeader("Authorization", "Bearer " + token);

        // 可选：也可以返回 JSON 响应体中的 token
        return ResponseEntity.ok().body(Map.of("token", token));
    }

    @PostMapping("/admin")
    public String admin() {

        return "admin";
    }
}

// 登录请求数据模型
class AuthRequest {
    private String username;
    private String password;

    // Getter 和 Setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}