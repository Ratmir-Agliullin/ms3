<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пароль неверный</title>
</head>
<body>
Ваш пароль неверный или пользователь под таким логином уже зарегистрирован.<br>
Попробуйте еще раз.<br>
<a href="/login">Авторизоваться</a>
<input onclick="location.href='/logOut'" type="submit" value="logout" style="float: right;">
</body>
</html>
