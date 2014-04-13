package com.tutorial.headfirst.beer.web;

import com.tutorial.headfirst.beer.model.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * User: Alexandr Date: 03.03.14 Time: 22:38
 */
public class BeerSelect extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>version with servlet only</h2>");
        out.println("Beer Selection Advice<br>");
        BeerExpert beerExpert = new BeerExpert();
        List<String> brands = beerExpert.getBrands(color);
        out.println("Got beer color " + color);
        for (String brand : brands) {
            out.println("<br>try " + brand);
        }
        out.println("<hr>");
        out.println("<h2>version with jsp dispatching<h2>");
        req.setAttribute("styles", brands);

        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);
    }
}
