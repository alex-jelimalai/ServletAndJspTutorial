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
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Text;
import com.it_tutorial.model.Course;
import com.it_tutorial.model.Subject;

/**
 * User: Alexandr Date: 06.04.14 Time: 20:47
 */
public class AddSubject extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        String cursName = request.getParameter(StoreEntities.COURSE);
        Query query = new Query(StoreEntities.COURSE).setFilter(new FilterPredicate(Course.NAME, FilterOperator.EQUAL, cursName));
        Entity course = datastore.prepare(query).asSingleEntity();
        String name = request.getParameter(Subject.NAME);
        Text description = new Text(request.getParameter(Subject.DESCRIPTION));
        Entity subject = new Entity(StoreEntities.SUBJECT, course.getKey());

        subject.setProperty(Subject.NAME, name);
        subject.setProperty(Subject.DESCRIPTION, description);
        subject.setProperty(Subject.DATE, new Date());
        datastore.put(subject);
        response.sendRedirect("/myadmin");
    }

}
