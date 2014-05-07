<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.datastore.Query.SortDirection" %>

<select name="course" width="300" style="width: 300px">
    <%
        {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Query query = new Query("course").addSort("name", SortDirection.ASCENDING);
            List<Entity> courses = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
            for (final Entity course : courses) {
                out.println("<option>" + course.getProperty("name") + "</option>");
            }
        }
    %>
</select>
