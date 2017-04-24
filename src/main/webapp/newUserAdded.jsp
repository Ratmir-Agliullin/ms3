<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новый пользователь добавлен</title>
</head>
<body>
${newuser}<br>
<a href="/login">Авторизоваться</a>
<input onclick="location.href='/logOut'" type="submit" value="logout" style="float: right;">
</body>
</html>
