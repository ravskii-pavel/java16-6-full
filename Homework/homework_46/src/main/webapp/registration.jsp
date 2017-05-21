<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 12.05.2017
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "d" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <style>
        <%@include file='css/main.css' %>
    </style>
</head>
<body style="margin: 20px 35% 20px 35%;">
    <%--<img src="../css/black-diamond-logo.png"/>--%>
    <img src="..<d:url value="/css/black-diamond-logo.png"/>" alt="login preview">
    <form class="form" action="<%=request.getServletContext().getContextPath()%>/registration" method="post">
        <div class="legend">Зпролните поля формы</div>
        <input class="textButton" name="name" placeholder="full name" type="text">
        <input class="textButton" name="login" placeholder="login" type="text">
        <input class="textButton" name="email" placeholder="email" type="text">
        <input class="textButton" name="password" placeholder="password" type="password"> <br>
        <input class="button" name="register" value="Confirm" type="submit">
    </form>
</body>
</html>
