<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.04.2017
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового администратора</title>
</head>
<body>
<form action  = "/newAdmin" method="post" style="display: inline">
    <input type = "text" name = "username"/><br>
    <input type = "text" name = "password"/><br>
    <input type = "submit" value="login">
</form>
<input onclick="location.href='/logOut'" type="submit" value="logout" style="float: right;">
</body>
</html>
