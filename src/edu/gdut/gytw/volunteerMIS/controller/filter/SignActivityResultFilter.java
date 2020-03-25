package edu.gdut.gytw.volunteerMIS.controller.filter;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;
import edu.gdut.gytw.volunteerMIS.entity.SignActivity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class SignActivityResultFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        List<SignActivity> list = MISeboFactory.getMISeboFactory().FindSingActivityResultBySno(Integer.parseInt(request.getSession().getAttribute("account").toString()));
        req.setAttribute("signActivityResults",list);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
