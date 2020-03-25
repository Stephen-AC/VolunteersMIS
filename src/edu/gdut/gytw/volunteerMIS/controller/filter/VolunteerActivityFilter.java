package edu.gdut.gytw.volunteerMIS.controller.filter;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;
import edu.gdut.gytw.volunteerMIS.entity.VolunteerActivity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class VolunteerActivityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        VolunteerActivity volunteerActivity = MISeboFactory.getMISeboFactory().getActivity(httpServletRequest.getParameter("title"));
        httpServletRequest.setAttribute("volunteerActivity",volunteerActivity);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
