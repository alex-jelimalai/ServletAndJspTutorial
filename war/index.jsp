<html>
<head><title>Welcome to tutorials zone</title>
    <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css"/>

</head>
<body style="background-color: #d4ebee">
<div id="topnav">
    <div id="topnavTut">
        <a class="topnav" target="_top" href="#">Home</a>
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
                <li><a class="left_links" href="#"><p><b>Creating first Servlet</b></p></a></li>
                <li><a class="left_links" href="#"><p><b>Do Get or Do Post</b></p></a></li>
                <li><a class="left_links" href="#"><p><b>Check Out the Jsp</b></p></a></li>
                <li><a class="left_links" href="#"><p><b>Be a Container</b></p></a></li>
                <li><a class="left_links" href="#"><p><b>Expression Language</b></p></a></li>
            </ul>
        </td>
        <td style="padding-top: 50px">
            <h1 align="center">Creating first servlet</h1>

            <p class="text">Internet Protocol version 6 (IPv6) is the latest revision of the Internet Protocol (IP) and
                the first
                version of the protocol to be widely deployed. IPv6 was developed by the Internet Engineering Task Force
                (IETF) to deal with the long-anticipated problem of IPv4 address exhaustion


            <code>import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Ch1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
	PrintWriter out = response.getWriter();
        Date today = <b>new Date()</b>;
        out.println("");
    }
}
            </code>
            </p>
        </td>
    </tr>

</table>
</body>
</html>
