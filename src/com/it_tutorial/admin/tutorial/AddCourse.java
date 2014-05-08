package com.it_tutorial.admin.tutorial;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StoreEntities;
import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.it_tutorial.model.Course;
import com.it_tutorial.model.Subject;
import com.it_tutorial.model.Tutorial;

/**
 * User: Alexandr Date: 06.04.14 Time: 20:47
 */
public class AddCourse extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceFactory.getUserService();
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        String tutorialName = request.getParameter(StoreEntities.TUTORIAL);
        Query query = new Query(StoreEntities.TUTORIAL).setFilter(new FilterPredicate(Tutorial.NAME, FilterOperator.EQUAL, tutorialName));
        Entity tutorial = datastore.prepare(query).asSingleEntity();
        String name = request.getParameter(Course.NAME);
        Text description = new Text(request.getParameter(Course.DESCRIPTION));
        Entity course = new Entity(StoreEntities.COURSE, tutorial.getKey());
        course.setProperty(Course.NAME, name);
        course.setProperty(Course.DESCRIPTION, description);
        course.setProperty(Course.DATE, new Date());
        datastore.put(course);
        response.sendRedirect("/myadmin");
    }

}
