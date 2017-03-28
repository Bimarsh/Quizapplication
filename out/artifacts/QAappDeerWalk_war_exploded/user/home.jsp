<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.User" %>
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



<div id="wrapper">
    <div id="header">
        <h3>Welcome: ${sessionScope.user.name}| <a href="logout">Logout</a></h3>
        <div id="logo">
            <h5>${message}</h5>
        </div>
        <div id="menu">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Photos</a></li>
                <c:if test="${sessionScope.user.role== 'quiztaker'}">
                <li><a href="quiz?page=allquestion">Take Quiz</a></li>       </li>
                    </c:if>
                <li class="last"><a href="#">Contact</a></li>
            </ul>
            <br class="clearfix" />
        </div>
    </div>
    <div id="page">
        <div id="sidebar">
            <div class="box">
                <ul class="list">
                    Your role:${sessionScope.user.role}
                    <c:set var ="usertype" value="${sessionScope.user.role}"/>
                       <c:if test="${usertype=='admin'}">
                    <li class="first"><a href="userlist?page=list">Manage User</a></li>
                    <li><a href="questionlist?query=view">Manage Questions</a></li>
                    </c:if>
                    <li class="last"><a href="#">Welcome</a></li>
                    <li class="last"><a href="#">Welcome</a></li>

                </ul>
            </div>

        </div>

        <div id="content">

            Here is Our content

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
