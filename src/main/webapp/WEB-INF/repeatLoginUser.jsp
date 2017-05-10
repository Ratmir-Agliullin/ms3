<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Пароль неверный</title>
</head>
<body>
Ваш пароль неверный или пользователь под таким логином уже зарегистрирован.<br>
Попробуйте еще раз.<br>
<a href="/login">Авторизоваться</a>
<input onclick="location.href='<c:url value="/j_spring_security_logout" />'"   class="login loginmodal-submit" type="submit" value="logout" style="float: right;">

</body>
</html>
