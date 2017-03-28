<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 5/18/2016
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%
      String message = (String)request.getAttribute("message");

      if(message!=null){
  %>

  <h1><%=message%></h1>

  <%}%>

<table border="1" width="30%" cellpadding="3" align="center">
 <form action="login" method="post">
     <tr>
         <td>Username</td>
         <td><input type="text" name="name" ></td>
     </tr>
     <tr>
         <td>Password</td>
         <td><input type="password" name="password"> </td>
     </tr>
     <tr>
         <td>
             <input type="submit" value="login">
         </td>

     </tr>
 </form>
</table>

  </body>
</html>
