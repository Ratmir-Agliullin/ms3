<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>

${check1.user_name}<br>
<c:forEach  items="${products}" var = "products">

    <tr>
        <td><c:out value="${products.id}"></c:out></td>
        <td><c:out value="${products.productName}"></c:out></td>
        <td><c:out value="${products.productPrice}"></c:out></td>
        <td><a href="/newOrder?id=${products.id}">Добавить товар в заказ</a></td>

    </tr><br>
</c:forEach><br>
<input onclick="location.href='/newOrder'" type="submit" value="Сформировать заказ" style="float: right;"><br>
<input onclick="location.href='/ordersOfUser'" type="submit" value="Посмотреть историю" style="float: right;"><br>
<input onclick="location.href='<c:url value="/j_spring_security_logout" />'" type="submit" value="logout" style="float: right;">

</form>

</body>
</html>
