package edu.gdut.gytw.volunteerMIS.controller.filter;

import com.sun.deploy.net.HttpRequest;
import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;
import edu.gdut.gytw.volunteerMIS.entity.Volunteer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class VolunteerInfoFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        if(request.getSession().getAttribute("role").equals("volunteer")){
            Volunteer volunteer = MISeboFactory.getMISeboFactory().getVolunteerInfo(Integer.parseInt(request.getSession().getAttribute("account").toString()));
            request.setAttribute("volunteer",volunteer);
            chain.doFilter(req, resp);
        }else {
            Volunteer volunteer = MISeboFactory.getMISeboFactory().getVolunteerInfo(Integer.parseInt(request.getParameter("sno")));
            request.setAttribute("volunteer",volunteer);
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
