package com.example.emarket;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@WebServlet(name = "Gift", value = "/gift")
public class Gift extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> gifts = Arrays.asList(
                "Chocolate Cake",
                "Markus Office Chair",
                "Playstation 5",
                "The Original Painting of The Last Supper",
                "Louis Vuitton Handbag",
                "Pineapple Pizza",
                "Half of The Blueprints of The Time Machine",
                "The Popemobile",
                "GTA 6"
        );
        Random rand = new Random();
        String randomGift = gifts.get(rand.nextInt(gifts.size()));
        request.setAttribute("gift", randomGift);
        getServletContext().getRequestDispatcher("/jsp/gift.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post gift");
    }
}
