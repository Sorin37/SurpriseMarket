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
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        request.setAttribute("token", currentUser.getToken());
        request.setAttribute("username", currentUser.getUsername());
        request.setAttribute("role", currentUser.getRole());
        request.setAttribute("points", currentUser.getPoints());

        getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);

        session.setAttribute("showToken", false);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

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

        if (currentPoints == 100 || currentPoints == 200 || currentPoints == 300 || currentPoints == 400) {
            response.sendRedirect("/gift");
        } else {
            getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}