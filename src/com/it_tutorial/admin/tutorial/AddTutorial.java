package com.it_tutorial.admin.tutorial;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StoreEntities;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.it_tutorial.model.Tutorial;

/**
 * User: Alexandr Date: 06.04.14 Time: 20:47
 */
public class AddTutorial extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String name = request.getParameter(Tutorial.NAME);
        String description = request.getParameter(Tutorial.DESCRIPTION);
        Entity tutorial = new Entity(StoreEntities.TUTORIAL);
        tutorial.setProperty(Tutorial.NAME, name);
        tutorial.setProperty(Tutorial.DESCRIPTION, description);
        tutorial.setProperty(Tutorial.DATE, new Date());
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(tutorial);

        response.sendRedirect("/myadmin");
    }

}
