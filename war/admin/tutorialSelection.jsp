<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.datastore.Query.SortDirection" %>

<select name="tutorial" width="300" style="width: 300px">
    <%
        {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Query query = new Query("tutorial").addSort("name", SortDirection.ASCENDING);
            List<Entity> tutorials = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
            for (final Entity tutorial : tutorials) {
                out.println("<option>" + tutorial.getProperty("name") + "</option>");
            }
        }
    %>
</select>
