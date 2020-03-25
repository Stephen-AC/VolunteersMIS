package edu.gdut.gytw.volunteerMIS.controller;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;
import edu.gdut.gytw.volunteerMIS.business.ebo.MISebo;
import edu.gdut.gytw.volunteerMIS.entity.PreVolunteer;
import edu.gdut.gytw.volunteerMIS.entity.Sex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


public class CreatePreVolunteerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        PreVolunteer preVolunteer = new PreVolunteer();
        preVolunteer.setSno(Integer.parseInt(request.getParameter("sno")));
        preVolunteer.setName(request.getParameter("name"));
        preVolunteer.setSex(Sex.getType(request.getParameter("sex")));
        preVolunteer.setGrade(Integer.parseInt(request.getParameter("grade")));
        preVolunteer.setMajor(request.getParameter("major"));
        preVolunteer.setSemester(request.getParameter("semester"));
        preVolunteer.setPhone(request.getParameter("phone"));
        preVolunteer.setDialect(request.getParameter("dialect"));
        preVolunteer.setSpeciality(request.getParameter("speciality"));
        preVolunteer.setReason(request.getParameter("reason"));
        preVolunteer.setExperience(request.getParameter("experience"));
        request.setAttribute("ifcreate",MISeboFactory.getMISeboFactory().createRegisterForm(preVolunteer));
        request.setAttribute("preVolunteer",preVolunteer);
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
