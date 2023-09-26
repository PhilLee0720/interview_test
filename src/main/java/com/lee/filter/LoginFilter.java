package com.lee.filter;//package com.lee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化过滤器（如果需要）
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();
        Object userInfo = session.getAttribute("userInfo");
        Boolean isLoggedIn = userInfo != null ? true : false;
        // 如果请求的是登录页面或登录请求,注册页面则允许访问
        if (requestURI.endsWith("login.jsp") || requestURI.endsWith("/")
                || requestURI.endsWith("login.do") || requestURI.endsWith("code") ||
                requestURI.endsWith("register.jsp") || requestURI.endsWith("index.jsp")
        ||requestURI.endsWith("register.do")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 如果用户已登录，则允许访问其他页面
        if (isLoggedIn) {
            filterChain.doFilter(request, response);
        } else {
            // 如果用户未登录，则重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
        }
    }

    @Override
    public void destroy() {
        // 清理资源（如果有的话）
    }
}