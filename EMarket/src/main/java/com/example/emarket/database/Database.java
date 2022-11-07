package com.example.emarket.database;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

public class Database {
    public Connection connect_to_db() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SurpriseMarket", "postgres", "sorin");
            if (connection != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public String addUser(Connection connection, String username) {
        Statement statement;
        String token = null;
        try {
            SecureRandom random = new SecureRandom();
            byte[] bytes = new byte[20];
            random.nextBytes(bytes);
            token = bytes.toString();
            System.out.println(token);
            String query = String.format("INSERT INTO public.users(token, username, role, points) " +
                    "VALUES ('%s', '%s', '%s', '%s')", token, username, "client", 0);
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return token;
    }
}
