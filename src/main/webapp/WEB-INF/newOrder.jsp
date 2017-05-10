<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 02.05.2017
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Формируем новый заказ</title>
</head>
<body>
<c:forEach  items="${products}" var = "products">

    <tr>
        <td><c:out value="${products.id}"></c:out></td>
        <td><c:out value="${products.productName}"></c:out></td>
        <td><c:out value="${products.productPrice}"></c:out></td>
        <td><a href="/newOrder?id=${products.id}">Добавить товар в заказ</a></td>
    </tr><br>
</c:forEach><br>
${check1.username}<br>
${resultSum}<br>
<input onclick="location.href='/userInfo'"   class="login loginmodal-submit" type="submit" value="Вернуться назад" style="float: right;"><br>
<input onclick="location.href='/createOrder'"   class="login loginmodal-submit" type="submit" value="Оформить заказ" style="float: right;"><br>
<input onclick="location.href='<c:url value="/j_spring_security_logout" />'"   class="login loginmodal-submit" type="submit" value="logout" style="float: right;">

</body>
</html>
