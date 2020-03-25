package edu.gdut.gytw.volunteerMIS.controller;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;
import edu.gdut.gytw.volunteerMIS.entity.VolunteerActivity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

@WebServlet(name = "ActivitesServlet",urlPatterns = {"/ActivitesServlet"})
public class ActivitesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        VolunteerActivity activity = new VolunteerActivity();
        activity.setTitle(request.getParameter("title"));
        activity.setTime(request.getParameter("time"));
        activity.setRequest(request.getParameter("request"));
        activity.setDetails(request.getParameter("details"));
        MISeboFactory.getMISeboFactory().createActivity(activity);
        request.setAttribute("activity",activity);
        request.setAttribute("ifcreate",true);
        request.getRequestDispatcher("createActivity.jsp").forward(request,response);
    }
}
