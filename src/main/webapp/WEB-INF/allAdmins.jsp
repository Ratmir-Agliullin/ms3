<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01.05.2017
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/main/webapp/css/styles.css" />"/>
    <title>Список всех администраторов</title>
</head>
<body>
<c:forEach  items="${users}" var = "users" >
    <table>
        <tr >
            <td><c:out value="${users.id}"></c:out></td>
            <td><c:out value="${users.adminName}"></c:out></td>

            <td><a href="/deleteAdmin?id=${users.id}">Удалить администратора</a> </td>
            <br>
        </tr>
    </table>
</c:forEach><br>
<input onclick="location.href='<c:url value="/j_spring_security_logout" />'"   class="login loginmodal-submit" type="submit" value="logout" style="float: right;">

</body>
</html>
