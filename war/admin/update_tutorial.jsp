<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="../stylesheets/admin.css"/>
    <title>Add New Subject</title>

</head>
<body>

<div style="margin: auto;width: 1000">

    <div style="float: left">
        <jsp:include page="/admin/menu.jsp"/>
    </div>

    <div style="float: left;">
        <jsp:include page="/admin/admin_title.jsp"/>
        <div style="float: left">
            <jsp:include page="${param.page}"/>
        </div>
    </div>
</div>

</body>
</html>