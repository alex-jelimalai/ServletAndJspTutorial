package com.it_tutorial.admin.tutorial;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * User: Alexandr
 * Date: 06.04.14
 * Time: 20:47
 */
public class AddTutorial extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Entity tutorial = new Entity("tutorial");
        tutorial.setProperty("name", name);
        tutorial.setProperty("description", description);
        tutorial.setProperty("user", user);
        tutorial.setProperty("date", new Date());
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(tutorial);

        response.sendRedirect("/admin");
    }

}
