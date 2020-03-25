package edu.gdut.gytw.volunteerMIS.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "CommonFilter")
public class CommonFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        httpServletRequest.setCharacterEncoding("utf8");
        chain.doFilter(httpServletRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
