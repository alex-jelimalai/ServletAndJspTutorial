<!DOCTYPE html>
<html>
<head>
    <title>Add New Tutorial</title>

    <style>
        .center {
            text-align: center;
            padding-left: 35%;
            padding-right: 35%;
        }

        .item {
            text-align: left;
            border: 1px solid black;
            background: #fffcde;
            padding: 5px;
        }
    </style>


</head>
<body>
<div class="center">
    <p class="item">
        <b>Put the right information:</b>
    </p>

    <form class="item" action="AddTutorial.do" method="post">
        Tutorial Name: </br><input type="text" name="name"><br/><br/>
        Description: </br><textarea rows="4" cols="35" name="description" style="resize:none"></textarea>
        </br>
        <input type="submit" value="Submit">
    </form>

</div>
</body>
</html>