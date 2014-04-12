package com.it_tutorial.admin.tutorial;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * User: Alexandr Date: 06.04.14 Time: 20:47
 */
public class AddSubject extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String curs = request.getParameter("curs");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Entity subject = new Entity("subject");
        subject.setProperty("name", name);
        subject.setProperty("curs", curs);
        subject.setProperty("description", description);
        subject.setProperty("user", user);
        subject.setProperty("date", new Date());
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(subject);

        response.sendRedirect("/myadmin");
    }

}
