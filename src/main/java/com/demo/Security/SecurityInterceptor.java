package com.demo.Security;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

        HttpSession session = request.getSession();
        User userInSession = (User) session.getAttribute("userInSession");

        if (uri.startsWith("/manager")){
            if (userInSession == null || !"MANAGER".equals(userInSession.getRole().toString())){
                response.sendRedirect("/");
                return true;
            }
        }

        return true;
    }
}
