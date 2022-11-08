package com.example.emarket;

import com.example.emarket.database.Database;
import com.example.emarket.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Login", urlPatterns = {"/login", "/"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        session.setAttribute("showToken", false);

        if (user != null) {
            response.sendRedirect("/home");
        } else {
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database db = new Database();
        Connection conn = db.connect_to_db();

        User user = db.getUser(conn, request.getParameter("loginToken"));
        if (user == null) {
            response.sendRedirect("/error");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            response.sendRedirect("/home");
        }
    }
}
