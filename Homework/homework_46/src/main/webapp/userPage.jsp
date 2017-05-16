<%--
  Created by IntelliJ IDEA.
  User: ravskiy
  Date: 15.05.2017
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
    <style>
        <%@include file='css/main.css' %>
    </style>

</head>
<body style="margin: 20px 35% 20px 35%;">
    <div class="form">
        <span>User name: ${userName}</span><br>
        <span>User login: ${userLogin}</span><br>
        <span>User email: ${userEmail}</span><br>
        <span>User password: ${userPassword}</span><br><br>
        <a class="button" href="/"> Home </a>
    </div>
</body>
</html>
