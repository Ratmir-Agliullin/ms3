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
    <title>All users</title>
</head>
<body>
${list}<br>

2330<br>
<c:forEach  items="${users}" var = "users">

    <tr>
        <td><c:out value="${users.id}"></c:out></td>
        <td><c:out value="${users.userName}"></c:out></td>
        <td><c:out value="${users.passName}"></c:out></td>
        <td><button type="submit">Удалить пользователя</button></td>
        <td><a href="/deleteUser?value=${users.id}">Удалить пользователя</a> </td>
        <br>
        </tr>
</c:forEach>

</body>
</html>
