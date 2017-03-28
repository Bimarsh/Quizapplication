<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="model.Question" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <title>My app</title>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Kreon" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../style.css" />
</head>
<body>

<%
    User user = (User)session.getAttribute("user");
%>

<div id="wrapper">
    <div id="header">
        <h3>Welcome to: <%=user.getName()%>| <a href="logout">Logout</a></h3>
        <div id="logo">

        </div>
        <div id="menu">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Photos</a></li>
                <li><a href="#">Portfolio</a></li>
                <li class="last"><a href="#">Contact</a></li>
            </ul>
            <br class="clearfix" />
        </div>
    </div>
    <div id="page">
        <div id="sidebar">
            <div class="box">
                <ul class="list">
                    <li class="first"><a href="quiz?page=allquestion">Take Quiz</a></li>
                    <li><a href="questionlist?query=view">Manage Question</a></li>
                    <li class="last"><a href="#">Welcome</a></li>
                    <li class="last"><a href="#">Welcome</a></li>

                </ul>
            </div>

        </div>

        <div id="content">




            <form action="submitanswer" method="post">


                <c:forEach var="entry" items="${answer}">
                    <table  border="1px" width="90%" align="center">
                        <tr bgcolor="aqua">
              <td colspan="3">
                  Question: <c:out value="${entry.key}"/>
              </td>
                    </tr>

                 <tr><td><c:forEach var="value" items="${entry.value}">
                     <c:out value="${value}"/> <input type="checkbox" name="answer"  value="<c:out value="${value}"/>"/></c:forEach></td>
                 </tr>
                    </table>
           </c:forEach>


                    <input type="submit" value="Submit Answer">

                    </form>


            <br class="clearfix" />
        </div>

        <br class="clearfix" />
    </div>

</div>
<div id="footer">
    &copy; My App | Deerwalk
</div>
</body>
</html>
