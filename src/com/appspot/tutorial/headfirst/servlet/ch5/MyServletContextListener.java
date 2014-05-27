package com.appspot.tutorial.headfirst.servlet.ch5;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * User: Alexandr
 * Date: 27.05.14
 * Time: 22:55
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String breed = servletContext.getInitParameter("breed");
        Dog dog = new Dog(breed);
        servletContext.setAttribute("dog", dog);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
