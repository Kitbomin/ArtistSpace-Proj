package com.example.artistspace._core.interceptor;

import com.example.artistspace.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            HttpSession session = request.getSession(false);

            if (session != null) {
                User sessionUser = (User) session.getAttribute("sessionUser");
                modelAndView.addObject("sessionUser", sessionUser);
            }
        }
    }
}
