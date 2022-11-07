package com.example.emarket;

import com.example.emarket.database.Database;
import com.example.emarket.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("REGISTER POST");
        Database db = new Database();
        Connection conn = db.connect_to_db();
        String newToken = db.addUser(conn, request.getParameter("username"));

        HttpSession session = request.getSession();
        User newUser = new User();

        newUser.setToken(newToken);
        newUser.setUsername(request.getParameter("username"));

        session.setAttribute("currentUser", newUser);

        session.setAttribute("showToken", true);

        response.sendRedirect("/home");
    }
}
