package edu.gdut.gytw.volunteerMIS.controller;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;
import edu.gdut.gytw.volunteerMIS.entity.VolunteerActivity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class SignActivityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VolunteerActivity volunteerActivity = new VolunteerActivity();
        volunteerActivity.setTitle(request.getParameter("title"));
        volunteerActivity.setTime(request.getParameter("time"));
        volunteerActivity.setRequest(request.getParameter("request"));
        volunteerActivity.setDetails(request.getParameter("details"));
        String title =  request.getParameter("title");
        String uri = URLEncoder.encode(title,"UTF-8");
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        if (MISeboFactory.getMISeboFactory().SignActivity(account,title)){
            request.setAttribute("ifcreate",true);
            request.setAttribute("volunteerActivity",volunteerActivity);
        }else {
            request.setAttribute("ifcreate",false);
            request.setAttribute("volunteerActivity",volunteerActivity);
        }
        request.getRequestDispatcher("volunteerActivity.jsp?title="+uri).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
