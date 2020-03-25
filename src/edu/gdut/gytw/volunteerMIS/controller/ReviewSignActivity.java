package edu.gdut.gytw.volunteerMIS.controller;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;
import edu.gdut.gytw.volunteerMIS.entity.SignActivity;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReviewSignActivity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        Long sno =  Long.parseLong(request.getParameter("sno"));
        String title = request.getParameter("title");
        String result = request.getParameter("result");
        SignActivity signActivity = new SignActivity();
        signActivity.setSno(sno);
        signActivity.setTitle(title);
        signActivity.setResult(result);
        if (MISeboFactory.getMISeboFactory().reviewSingActivity(signActivity)){
            context.setAttribute(signActivity.getSno()+signActivity.getTitle(),true);
            response.sendRedirect("reviewSignActivity.jsp");
        }else {
            context.setAttribute(signActivity.getSno()+signActivity.getTitle(),false);
            response.sendRedirect("reviewSignActivity.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
