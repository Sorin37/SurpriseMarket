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

        request.setAttribute("token", currentUser.getToken());
        request.setAttribute("username", currentUser.getUsername());
        request.setAttribute("role", currentUser.getRole());
        request.setAttribute("points", currentUser.getPoints());

        getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);

        session.setAttribute("showToken", false);
//        session.setAttribute("currentUser", currentUser);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DO POST");

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        System.out.println(currentUser);

        request.setAttribute("username", currentUser.getUsername());
        request.setAttribute("role", currentUser.getRole());

        long currentPoints = currentUser.getPoints();
        if (Float.parseFloat(request.getParameter("fullPrice")) >= 100 && currentUser.getRole().equals("client")) {
            currentPoints += 10;
            currentUser.setPoints(currentPoints);
            session.setAttribute("currentUser", currentUser);
            Database db = new Database();
            Connection conn = db.connect_to_db();
            db.updatePoints(conn, currentUser.getToken(), currentPoints);
        }

        request.setAttribute("points", currentPoints);

        getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
//        session.setAttribute("currentUser", currentUser);
    }

    public void destroy() {
    }
}