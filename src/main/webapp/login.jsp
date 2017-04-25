<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 20.04.2017
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/styles.css" />"/>
    <title>Login</title>
</head>
<body>
<div class="modal-dialog">
    <div class="middle-div">
        <div class="loginmodal-container" id="loginDiv">
<form action  = "/login" method="post" style="display: inline">
    <input type = "text" name = "username"/>
    <input type="password" name = "password"/>
    <input type = "submit" class="login loginmodal-submit" value="login">
</form>

</body>
</html>
