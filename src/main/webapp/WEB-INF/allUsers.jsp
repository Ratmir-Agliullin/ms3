<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22.04.2017
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/main/webapp/css/styles.css" />"/>
    <title>All users</title>
</head>
<body>
${list}<br>

2330<br>
<c:forEach  items="${users}" var = "users" >
<table>
    <tr >
        <td><c:out value="${users.id}"></c:out></td>
        <td><c:out value="${users.userName}"></c:out></td>
        <td><button type="submit">Удалить пользователя</button></td>
        <td><a href="/deleteUser?id=${users.id}">Удалить пользователя</a> </td>
        <br>
        </tr>
    </table>
</c:forEach><br>
<input onclick="location.href='/allAdmins'"   class="login loginmodal-submit" type="submit" value="allAdmins" style="float: right;">
<input onclick="location.href='/allOrders'"   class="login loginmodal-submit" type="submit" value="allOrders" style="float: right;">
<input onclick="location.href='/newAdminAdd'"   class="login loginmodal-submit" type="submit" value="Add new admin" style="float: right;">
<input onclick="location.href='<c:url value="/j_spring_security_logout" />'"   class="login loginmodal-submit" type="submit" value="logout" style="float: right;">
</body>
</html>
