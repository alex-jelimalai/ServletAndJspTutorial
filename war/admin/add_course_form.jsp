<form class="item" action="AddCurs.do" method="post">
    Select Tutorial: <br/><label>
    <%@include file="tutorialSelection.jsp" %>
</label>
    <br/>
    Course Name: <br/><label>
    <input type="text" name="name" style="width: 300px">
</label><br/><br/>
    Description: <br/><label>
    <textarea rows="4" cols="35" name="description" style="resize:none"></textarea>
</label>
    <br/>
    <input type="submit" value="Submit">
</form>