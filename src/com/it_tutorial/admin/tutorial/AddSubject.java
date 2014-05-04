package com.it_tutorial.admin.tutorial;

import com.StoreFields;
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
 * User: Alexandr Date: 06.04.14 Time: 20:47
 */
public class AddSubject extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String curs = request.getParameter(StoreFields.CURS);
        String name = request.getParameter(StoreFields.NAME);
        String description = request.getParameter(StoreFields.DESCRIPTION);
        Entity subject = new Entity(StoreFields.SUBJECT);
        subject.setProperty(StoreFields.NAME, name);
        subject.setProperty(StoreFields.CURS, curs);
        subject.setProperty(StoreFields.DESCRIPTION, description);
        subject.setProperty(StoreFields.USER, user);
        subject.setProperty(StoreFields.DATE, new Date());
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(subject);

        response.sendRedirect("/myadmin");
    }

}
