package com.example.emarket;

import com.example.emarket.database.Database;
import com.example.emarket.model.User;

import java.io.*;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "mainPage", value = "/home")
public class MainPage extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("DO GET");
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        session.setAttribute("currentUser", currentUser);
        request.setAttribute("token", currentUser.getToken());
        request.setAttribute("username", currentUser.getUsername());
        request.setAttribute("points", currentUser.getPoints());

        getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);

        session.setAttribute("showToken", false);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DO POST");

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        request.setAttribute("username", currentUser.getUsername());

        long currentPoints = currentUser.getPoints();
        if (Float.parseFloat(request.getParameter("fullPrice")) >= 100) {
            currentPoints += 10;
            currentUser.setPoints(currentPoints);
            session.setAttribute("currentUser", currentUser);
            Database db = new Database();
            Connection conn = db.connect_to_db();
            db.updatePoints(conn, currentUser.getToken(), currentPoints);
        }

        request.setAttribute("points", currentPoints);

        getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}