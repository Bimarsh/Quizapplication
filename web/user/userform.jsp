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

<%

    String message = (String)request.getAttribute("message");
%>

<div id="wrapper">
    <div id="header">
        <h3>Welcome to: ${sessionScope.user.name}| <a href="logout">Logout</a></h3>
        <div id="logo">
            <h5>${message}</h5>
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
                    <li class="first"><a href="userlist?page=list">Manage User</a></li>
                    <li><a href="questionlist?query=view">Manage Questions</a></li>
                    <li class="last"><a href="#">Welcome</a></li>
                    <li class="last"><a href="#">Welcome</a></li>

                </ul>
            </div>

        </div>

        <c:if test="${userform!=null}">
        <div id="content">

            <form method="post" action="update">

                <input type="hidden" name="id" value="${userform.id}">
                <input type="hidden" name="page" value="update">
                <center>
                    <table border="1" width="50%" cellpadding="5" align="center">
                        <thead>
                        <tr>
                            <th colspan="2">Edit User</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>User Name</td>
                            <td><input type="text" name="username" value="${userform.name}"></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password" value="${userform.password}"></td>
                        </tr>

                        <tr>
                            <td>Role</td>
                            <td><input type="text" name="role"  value="${userform.role}"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Update"></td>
                            <td><input type="submit" value="Cancel" /></td>
                        </tr>
                        </tbody>
                    </table>
                </center>
            </form>

            <br class="clearfix" />
        </div>
        </c:if>
        <c:if test="${question!=null}">
        <div id="content1">

            <form method="post" action="questionupdate">

                <input type="hidden" name="id" value="${question.id}">
                <input type="hidden" name="query" value="questionupdate">
                <center>
                    <table border="1" width="50%" cellpadding="5" align="center">
                        <thead>
                        <tr>
                            <th colspan="2">Edit Question</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Question</td>
                            <td><input type="text" name="question" value="${question.question}"></td>
                        </tr>
                        <tr>
                            <td>Option A</td>
                            <td><input type="text" name="optionA" value="${question.optionA}"></td>
                        </tr>

                        <tr>
                            <td>Option B</td>
                            <td><input type="text" name="optionB"  value="${question.optionB}"></td>
                        </tr>
                        <tr>
                            <td>Option C</td>
                            <td><input type="text" name="optionC"  value="${question.optionC}"></td>
                        </tr>
                        <tr>
                            <td>Right Answer</td>
                            <td><input type="text" name="rightAnswer"  value="${question.rightAnswer}"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Update"></td>
                            <td><input type="submit" value="Cancel" /></td>
                        </tr>
                        </tbody>
                    </table>
                </center>
            </form>

            <br class="clearfix" />
        </div>
        </c:if>
        <br class="clearfix" />
    </div>

</div>
<div id="footer">
    &copy; My App | Deerwalk
</div>
</body>
</html>
