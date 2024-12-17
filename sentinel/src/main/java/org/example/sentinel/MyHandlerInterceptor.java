package org.example.sentinel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class MyHandlerInterceptor implements HandlerInterceptor {

    // 在控制器处理之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PreHandle: 请求处理前");
//        // 例如，验证用户是否登录
//        String token = request.getHeader("Authorization");
//        if (token == null || !isValidToken(token)) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().write("Unauthorized");
//            return false; // 中断请求
//        }
        return true; // 放行
    }

    // 在整个请求完成后执行（如清理资源等）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AfterCompletion: 请求处理完成");
    }

    // 模拟验证逻辑
    private boolean isValidToken(String token) {
        return "valid-token".equals(token);
    }
}
