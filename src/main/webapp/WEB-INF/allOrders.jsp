<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 05.05.2017
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Все заказы</title>
</head>
<body>
<c:forEach  items="${orders}" var = "orders">

    <tr>
        <td><c:out value="${orders.id}"></c:out></td>
        <td><c:out value="${orders.time}"></c:out></td>
        <td><c:out value="${orders.orderName}"></c:out></td>
        <td><c:out value="${orders.status}"></c:out></td>
        <td><c:out value="${orders.resultPrice}"></c:out></td>
        <td><a href="/deleteOrder?id=${orders.id}">Удалить заказ</a> </td>



    </tr><br>
</c:forEach><br>
<input onclick="location.href='<c:url value="/j_spring_security_logout" />'"   class="login loginmodal-submit" type="submit" value="logout" style="float: right;">

</body>
</html>
