<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

            <form method="post" action="adduser">


                <input type="hidden" name="page" value="adduser">
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
                            <td><input type="text" name="username" ></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password" ></td>
                        </tr>

                        <tr>
                            <td>Role</td>
                            <td><input type="text" name="role" ></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Add"></td>
                            <td><input type="submit" value="Cancel" /></td>
                        </tr>
                        </tbody>
                    </table>
                </center>
            </form>

            <br class="clearfix" />
        </div>
        </c:if>
    </div>
     <c:if test="${questionList!=null}">
    <div id="content1">

        <form method="post" action="addnewquestion">


            <input type="hidden" name="query" value="addnewquestion">
            <center>
                <table border="1"  cellpadding="5" align="center">
                    <thead>
                    <tr>
                        <th colspan="2">Add Questions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Question</td>
                        <td><input type="text" name="question" ></td>
                    </tr>
                    <tr>
                        <td>Option A</td>
                        <td><input type="text" name="optionA" ></td>
                    </tr>
                    <tr>
                        <td>Option B</td>
                        <td><input type="text" name="optionB"> </td>
                    </tr>
                    <tr>
                        <td>Option C</td>
                        <td><input type="text" name="optionC"> </td>
                    </tr>

                    <tr>
                        <td>Right Answer</td>
                        <td><input type="text" name="rightAnswer" ></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Add"></td>
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
