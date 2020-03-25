package edu.gdut.gytw.volunteerMIS.controller;

import edu.gdut.gytw.volunteerMIS.business.Factory.MISeboFactory;
import edu.gdut.gytw.volunteerMIS.entity.Volunteer;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class SaveVolunteerInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Volunteer volunteer = new Volunteer();
        volunteer.setSno(Integer.parseInt(request.getSession().getAttribute("account").toString()));
        volunteer.setMajor(request.getParameter("major"));
        volunteer.setSemester(request.getParameter("semester"));
        volunteer.setPhone(request.getParameter("phone"));
        volunteer.setNative_place(request.getParameter("native_place"));
        volunteer.setDialect(request.getParameter("dialect"));
        volunteer.setCharacter(request.getParameter("character"));
        volunteer.setSpeciality(request.getParameter("speciality"));
        volunteer.setWechat(request.getParameter("wechat"));
        volunteer.setQq(request.getParameter("qq"));
        volunteer.setDrom(request.getParameter("drom"));
        volunteer.setVolExperience(request.getParameter("vol_experience"));
        volunteer.setExperience(request.getParameter("experience"));
        volunteer.setOthers(request.getParameter("others"));
        MISeboFactory.getMISeboFactory().saveVolunteerInfo(volunteer);
        ServletContext context = request.getServletContext();
        context.setAttribute("ifsave",true);
        response.sendRedirect("volunteerInfo.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
