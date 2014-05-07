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
        <td style="padding-left: 10px; padding-top: 10px; border-right:1px solid #bcd3d2;   background-color: #9ab7ff">
            <ul>
                <c:forEach var="course" items="${COURSES}">
                    <c:url value="ShowSubjects.do" var="url">
                        <c:param name="course" value="${course.name}"/>
                    </c:url>
                    <li><a href="./${url}"><b>${course.name}</b></a></li>
                </c:forEach>
            </ul>
        </td>
        <td style="padding-top: 50px">
            <p>
                ${DESCRIPTION}
            </p>
        </td>
    </tr>

</table>
<jsp:include page="footer.jsp"/>
</body>
</html>
