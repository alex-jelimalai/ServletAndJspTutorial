<%@ page import="com.it_tutorial.model.Course" %>
<%@ page import="com.it_tutorial.service.CourseService" %>


<select name="course" width="300" style="width: 300px">
    <%
        {
            CourseService courseService = new CourseService();
            for (final Course course : courseService.getAll()) {
                out.println("<option>" + course.getName() + "</option>");
            }
        }
    %>
</select>
