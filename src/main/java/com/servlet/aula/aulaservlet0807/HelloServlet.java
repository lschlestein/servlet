package com.servlet.aula.aulaservlet0807;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getServletPath();
        if (action.equals("/login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            System.out.println("Email: " + email + " Password: " + password);
            if (email.equals("lucas@mail.com") && password.equals("123")) {


            }
        }
    }
}