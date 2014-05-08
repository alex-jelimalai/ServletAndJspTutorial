package com.it_tutorial.provider;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it_tutorial.service.TutorialService;

/**
 * User: Alexandr Date: 03.05.14 Time: 16:50
 */
public class TutorialInfoProvider extends HttpServlet {

    public static final String TITLE = "Computer technologies";
    private final TutorialService tutorialService;


    public TutorialInfoProvider() {
        tutorialService = new TutorialService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("TUTORIALS", tutorialService.getAll());
        req.setAttribute("TITLE", TITLE);
        RequestDispatcher view = req.getRequestDispatcher("tutorials.jsp");
        view.forward(req, resp);
    }

}
