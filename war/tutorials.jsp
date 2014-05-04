<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head><title>Welcome to tutorials zone</title>
    <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css"/>

</head>
<body style="background-color: #d4ebee">
<div id="topnav">
    <div id="topnavTut">
        <a class="topnav" target="_top" href="./ShowTutorials.do">Home</a>
        <a class="topnav" target="_top" href="#">Admin</a>
        <a class="topnav" target="_top" href="#">About</a>
        <a class="topnav" target="_top" href="#">Contacts</a>
    </div>
</div>
<table class="base_table">
    <tr>
        <th style="width: 25%; background-color: blue; border-radius: 5px"><a href="index.jsp"><img
                src="img/it_logo.png"></a></th>
        <th class="base_title">Let's explore computer technologies</th>
    </tr>
    <tr class="big_row_table" valign="top">
        <td style="padding-left: 10px; padding-top: 10px; border-right:1px solid #bcd3d2;   background-color: #9ab7ff">
            <ul>
                <c:forEach var="tutorial" items="${TUTORIALS}">
                    <c:url value="ShowCourses.do" var="url">
                        <c:param name="tutorial" value="${tutorial}"/>
                    </c:url>
                    <li><a class="left_links" href="./${url}"><p><b>${tutorial}</b></p></a></li>
                </c:forEach>
            </ul>
        </td>
        <td style="padding-top: 50px">
            <jsp:include page="firstPageContain.jsp"/>
        </td>
    </tr>

</table>
</body>
</html>
