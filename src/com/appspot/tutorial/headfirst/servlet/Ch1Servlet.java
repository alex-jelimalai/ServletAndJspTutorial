package com.appspot.tutorial.headfirst.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Ch1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Date today = new Date();
        out.println("<html> " +
                "<body>" +
                "<h1 align=center>HF\'s Chapter1 Servlet"
                + "<br>" + today + "</body>" + "</html>");
    }
}
