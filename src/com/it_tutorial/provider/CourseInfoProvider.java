package com.it_tutorial.provider;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StoreEntities;
import com.it_tutorial.model.Tutorial;
import com.it_tutorial.service.CourseService;
import com.it_tutorial.service.TutorialService;

/**
 * User: Alexandr Date: 04.05.14 Time: 20:58
 */
public class CourseInfoProvider extends HttpServlet {

    private final TutorialService tutorialService;
    private final CourseService courseService;


    public CourseInfoProvider() {
        tutorialService = new TutorialService();
        courseService = new CourseService();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedTutorialName = request.getParameter(StoreEntities.TUTORIAL);
        request.setAttribute("TITLE", selectedTutorialName);
        request.setAttribute("COURSES", courseService.getByTutorial(selectedTutorialName));
        Tutorial selectedTutorial = tutorialService.getByName(selectedTutorialName);
        request.setAttribute("DESCRIPTION", selectedTutorial.getDescription());
        RequestDispatcher view = request.getRequestDispatcher("courses.jsp");
        view.forward(request, response);
    }
}
