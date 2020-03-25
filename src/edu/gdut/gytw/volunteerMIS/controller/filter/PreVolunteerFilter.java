package edu.gdut.gytw.volunteerMIS.controller.filter;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class PreVolunteerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setAttribute("preVolunteerList", MISeboFactory.getMISeboFactory().findAllPreVolunteer());
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
