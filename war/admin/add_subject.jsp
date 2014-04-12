<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../stylesheets/admin.css"/>
    <title>Add New Subject</title>

</head>
<body>
<div class="center" style="height:200px; width:320px;">
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

                <form class="item" action="AddSubject.do" method="post">
                    Subject Name: <br/><label>
                    <input type="text" name="name">
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