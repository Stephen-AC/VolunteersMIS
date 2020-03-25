package edu.gdut.gytw.volunteerMIS.controller;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReviewPreVolunteerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        if (request.getParameter("result").equals("pass")){
            MISeboFactory.getMISeboFactory().passPreVolunteer(Integer.parseInt(sno));
            request.setAttribute("passSuccess",true);
            request.setAttribute("sno",sno);
            request.getRequestDispatcher("preVolunteer.jsp").forward(request,response);
        }
        if (request.getParameter("result").equals("rejuect")){
            MISeboFactory.getMISeboFactory().rejectPreVolunteer(Integer.parseInt(sno));
            request.setAttribute("rejectSuccess",true);
            request.setAttribute("sno",sno);
            request.getRequestDispatcher("preVolunteer.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
