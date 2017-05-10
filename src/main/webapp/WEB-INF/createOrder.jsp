<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 04.05.2017
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Создан новый заказ</title>
</head>
<body>
Ваш заказ создан!<br>
${ordername}<br>
${summa}<br>
${contain}
<input onclick="location.href='<c:url value="/j_spring_security_logout" />'"  type="submit" value="logout" >

</body>
</html>
