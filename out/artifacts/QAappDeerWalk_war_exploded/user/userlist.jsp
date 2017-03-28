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
                    <li class="first"><a href="userlist?page=list">Manage User</a></li>
                    <li><a href="questionlist?query=view">Manage Questions</a></li>
                    <li class="last"><a href="#">Welcome</a></li>
                    <li class="last"><a href="#">Welcome</a></li>

                </ul>
            </div>

        </div>
        <c:if test="${userList!=null}">
        <div id="content">



            <a href="add?page=add">New User</a>
            <table  border="1px" width="50%">
                <tr bgcolor="aqua">
                    <td>User Name</td>
                    <td>Password</td>
                    <td>Role</td>
                    <td>Edit</td>
                    <td>Delete</td>
                </tr>


                <c:forEach var="user1" items="${userList}">
                <tr>
                    <td>${user1.name}</td>
                    <td>${user1.password}</td>
                    <td>${user1.role}</td>
                    <td><a href="edit?id=${user1.id}&page=edit">Edit</a></td>
                    <td><a href="delete?id=${user1.id}&page=delete">Delete</a></td>
                </tr>
                </c:forEach>



            </table>


            <br class="clearfix" />
        </div>
        </c:if>
        <c:if test="${questionList!=null}">
        <div id="content2">



            <a href="addquestion?query=add">New Question</a>
            <table  border="1px" width="50%">
                <tr bgcolor="aqua">
                    <td>Question</td>
                    <td>Option A</td>
                    <td>Option B</td>
                    <td>Option C</td>
                    <td>Right Answer</td>
                    <td>Edit</td>
                    <td>Delete</td>
                </tr>

               <c:forEach var="item" items="${questionList}">
                <tr>
                    <td>${item.question}</td>
                    <td>${item.optionA}</td>
                    <td>${item.optionB}</td>
                    <td>${item.optionC}</td>
                    <td>${item.rightAnswer}</td>
                    <td><a href="questionedit?id=${item.id}&query=edit">Edit</a></td>
                    <td><a href="questiondelete?id=${item.id}&query=delete">Delete</a></td>
                </tr>

                </c:forEach>

            </table>


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
