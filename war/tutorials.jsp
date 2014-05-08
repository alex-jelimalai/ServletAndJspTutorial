<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head><title>Welcome to tutorials zone</title>
    <link rel="stylesheet" type="text/css" href="stylesheets/main.css"/>

</head>
<body>
<jsp:include page="head_menu.jsp"/>
<table class="base_table">
    <jsp:include page="header.jsp"/>
    <tr class="big_row_table" valign="top">
        <td id="left_menu">
            <ul>
                <c:forEach var="tutorial" items="${TUTORIALS}">
                    <c:url value="ShowCourses.do" var="url">
                        <c:param name="tutorial" value="${tutorial.name}"/>
                    </c:url>
                    <li><a href="./${url}"><b>${tutorial.name}</b></a></li>
                </c:forEach>
            </ul>
        </td>
        <td style="padding-top: 50px">
            <jsp:include page="firstPageContain.jsp"/>
        </td>
    </tr>

</table>
<jsp:include page="footer.jsp"/>
</body>
</html>
