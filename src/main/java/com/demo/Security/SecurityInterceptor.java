package com.demo.Security;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.demo.Model.User;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
    
        if (uri.equalsIgnoreCase("/")){
            return true;
        }

        if (uri.startsWith("/home/manager")){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Boolean isManager = auth.getAuthorities().stream()
                                .anyMatch(a -> a.getAuthority().equals("ROLE_MANAGER"));
            if (!isManager){
                response.sendRedirect("/");
                return true;
            }
        }

        return true;
    }
}
