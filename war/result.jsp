<%@ page import="java.util.List" %>
<html>
<body>
<h3 align="center">Beer Recommendation JSP</h3>
<%
    List styles = (List)request.getAttribute("styles");
    for (Object style : styles) {
        out.println("<br> " + style);
    }
%>
</body>
</html>