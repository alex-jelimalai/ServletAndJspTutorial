package com.appspot.tutorial.headfirst.servlet.ch4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * User: Alexandr
 * Date: 18.05.14
 * Time: 17:51
 */
public class JarReturner extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/jar");

        ServletContext servletContext = getServletContext();
        InputStream stream = servletContext.getResourceAsStream("/emptyJar.jar");

        int read = 0;
        byte[] bytes = new byte[1024];

        ServletOutputStream outputStream = resp.getOutputStream();
        while ((read = stream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
        outputStream.flush();
        outputStream.close();
    }
}
