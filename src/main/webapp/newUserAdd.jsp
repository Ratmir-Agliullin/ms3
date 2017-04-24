<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового пользователя</title>
</head>
<body>
<script type="text/javascript">
    function checkForm(login,pass)
    {


        if(pass.value.length < 4) //длина меньше 4
        {
            alert('Пароль должен быть больше 4 символов!');
            return false;
        }

        if(/^[a-zA-Z1-9]+$/.test(login) === false)
        {alert('В логине должны быть только латинские буквы'); return false;}
        if(/^[a-zA-Z1-9]+$/.test(pass) === false)
        {alert('В логине должны быть только латинские буквы'); return false;}

        if(login.value.length < 4) //длина меньше 4
        {
            alert('Логин должен быть больше 4 символов!');
            return false;
        }
        return true;
    }
</script>
Добавьте ваши логин и пароль:<br>
<form action  = "/newUserAdd" method="post" onsubmit="return checkForm(username,password);" style="display: inline">
    <input type = "text" name = "username" id = "login"/><br>
    <input type = "password" name = "password" id = "pass"/><br>
    <input type = "submit" value="login">
</form>
<input onclick="location.href='/logOut'" type="submit" value="logout" style="float: right;">
</body>

</html>
