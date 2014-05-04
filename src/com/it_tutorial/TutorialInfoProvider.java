package com.it_tutorial;

import com.StoreFields;
import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.SortDirection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Alexandr
 * Date: 03.05.14
 * Time: 16:50
 */
public class TutorialInfoProvider extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query query = new Query(StoreFields.TUTORIAL).addSort(StoreFields.NAME, SortDirection.ASCENDING);
        List<Entity> tutorials = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
        List<String> tutorialNames = new ArrayList<>();
        for (Entity tutorial : tutorials) {
            String name = tutorial.getProperty(StoreFields.NAME).toString();
            tutorialNames.add(name);
        }
        req.setAttribute("TUTORIALS", tutorialNames);
        RequestDispatcher view = req.getRequestDispatcher("tutorials.jsp");
        view.forward(req, resp);
    }


}
