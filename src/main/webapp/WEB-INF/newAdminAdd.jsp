<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01.05.2017
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добавить нового администратора</title>
</head>
<body>
Добавьте логин и пароль нового администратора:<br>
<form action  = "/newAdminAdd" method="post" style="display: inline">
    <input type = "text" name = "username" id = "login"/><br>
    <input type = "password" name = "password" id = "pass"/><br>
    <input type = "submit" value="login">
</form>
<input onclick="location.href='<c:url value="/j_spring_security_logout" />'"   class="login loginmodal-submit" type="submit" value="logout" style="float: right;">

</body>
</html>
