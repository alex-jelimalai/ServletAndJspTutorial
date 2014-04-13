<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="../stylesheets/admin.css"/>
    <title>Add New Curs</title>

</head>
<body>
<div style="height:200px; width:200px;">
    <table class="base_table">
        <tr>
        <tr>
            <td>
                <%@include file="menu.jsp" %>
            </td>
            <td>

                <p class="item">
                    <b>Put the right information:</b>
                </p>

                <form class="item" action="AddCurs.do" method="post">
                    Select Tutorial: <br/><label>
                    <%@include file="tutorialSelection.jsp" %>
                </label>
                    <br/>
                    Curs Name: <br/><label>
                    <input type="text" name="name" style="width: 300px">
                </label><br/><br/>
                    Description: <br/><label>
                    <textarea rows="4" cols="35" name="description" style="resize:none"></textarea>
                </label>
                    <br/>
                    <input type="submit" value="Submit">
                </form>


            </td>
        </tr>

    </table>

</div>
</body>
</html>