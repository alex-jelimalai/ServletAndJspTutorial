package com.it_tutorial.provider;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StoreEntities;
import com.it_tutorial.service.CourseService;
import com.it_tutorial.service.SubjectService;

/**
 * User: Alexandr Date: 04.05.14 Time: 20:58
 */
public class SubjectInfoProvider extends HttpServlet {

    private final SubjectService subjectService;
    private final CourseService courseService;


    public SubjectInfoProvider() {
        courseService = new CourseService();
        subjectService = new SubjectService();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedCurs = request.getParameter(StoreEntities.COURSE);
        request.setAttribute("TITLE", selectedCurs);
        request.setAttribute("SUBJECTS", subjectService.getByCourse(selectedCurs));
        request.setAttribute("COURSES", courseService.getCoursesWithCommonTutorial(selectedCurs));
        request.setAttribute("DESCRIPTION", courseService.getByName(selectedCurs).getDescription());
        RequestDispatcher view = request.getRequestDispatcher("subjects.jsp");
        view.forward(request, response);
    }
}
