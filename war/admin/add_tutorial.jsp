<!DOCTYPE html>
<html>
<head>
    <title>Add New Tutorial</title>

    <style>
        .center {
            text-align: center;
            padding-left: 40%;
            padding-right: 40%;
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
        Tutorial Name: <input type="text" name="name" size="40"><br/><br/>
        Description: <textarea rows="4" cols="37" name="description" style="resize:none"></textarea>
        <input type="submit" value="Submit">
    </form>

</div>
</body>
</html>