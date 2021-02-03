package com.bofa.payment.scoreAPI.filter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "CheckAgentFilter", urlPatterns = "/*")
public class CheckAgentFilter implements Filter {

    private Log log = LogFactory.getLog(CheckAgentFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String url[] = req.getRequestURI().split("/");

        if(!(url[1].indexOf("login") > -1 || url[1].indexOf("register") > -1|| url[1].indexOf("addAgent") > -1)) {
            if (req.getSession().getAttribute("userAgent") == null) {
                HttpServletResponse res = (HttpServletResponse) servletResponse;
                res.sendRedirect(req.getContextPath() + "/login.html");
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
