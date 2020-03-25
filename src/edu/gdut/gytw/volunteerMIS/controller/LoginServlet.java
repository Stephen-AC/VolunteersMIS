package edu.gdut.gytw.volunteerMIS.controller;

import edu.gdut.gytw.volunteerMIS.common.DBconnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.locks.StampedLock;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String account = request.getParameter("account");
        String role = request.getParameter("role");
        Connection conn = null;
        String sql = null;
        Statement stmt = null;
        try {
            conn = DBconnection.getConn();
            if (role.equals("volunteer")){
                sql = "select password from clients where account="+account;
            }
            else{
                sql = "select password from administrators where account="+account;
            }
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.next()){
                request.setAttribute("check", true);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            rs.previous();
            while (rs.next()) {
                if (password.equals(rs.getString(1))) {
                    request.getSession().setAttribute("account", account);
                    request.getSession().setAttribute("role",role);
                    response.sendRedirect("index.jsp");
                } else {
                    request.setAttribute("check", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
