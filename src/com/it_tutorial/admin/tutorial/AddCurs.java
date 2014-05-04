package com.it_tutorial.admin.tutorial;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StoreFields;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * User: Alexandr Date: 06.04.14 Time: 20:47
 */
public class AddCurs extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String tutorial = request.getParameter(StoreFields.TUTORIAL);
        String name = request.getParameter(StoreFields.NAME);
        String description = request.getParameter(StoreFields.DESCRIPTION);
        Entity curs = new Entity(StoreFields.CURS);
        curs.setProperty(StoreFields.NAME, name);
        curs.setProperty(StoreFields.TUTORIAL, tutorial);
        curs.setProperty(StoreFields.DESCRIPTION, description);
        curs.setProperty(StoreFields.USER, user);
        curs.setProperty(StoreFields.DATE, new Date());
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(curs);

        response.sendRedirect("/myadmin");
    }

}
