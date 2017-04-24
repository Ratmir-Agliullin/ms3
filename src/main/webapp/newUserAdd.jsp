<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового пользователя</title>
</head>
<body>
Добавьте ваши логин и пароль:<br>
<form action  = "/newUserAdd" method="post">
    <input type = "text" name = "username"/><br>
    <input type = "text" name = "password"/><br>
    <input type = "submit" value="login">
</form>
</body>
</html>
