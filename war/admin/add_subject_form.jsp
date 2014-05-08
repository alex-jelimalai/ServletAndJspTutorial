<form class="item" action="AddSubject.do" method="post">
    Select Tutorial: <br/><label>
    <%@include file="tutorialSelection.jsp" %>
</label>
    <br/> Select Course: <br/><label>
    <%@include file="cursSelection.jsp" %>
</label>
    <br/>
    Subject Name: <br/><label>
    <input type="text" name="name" style="width: 300px">
</label><br/><br/>
    Description: <br/><label>
    <textarea rows="80" cols="100" name="description" style="resize:none"></textarea>
</label>
    <br/>
    <input type="submit" value="Submit">
</form>