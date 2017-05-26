<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 12.05.2017
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign in</title>
    <style>
        <%@include file='css/main.css' %>
    </style>
</head>
<body style="margin: 20px 35% 20px 35%;">

    <form class="form" action="<%=request.getServletContext().getContextPath()%>/login" method="post">
        <div class="legend">${enterSystem}</div>
        <input class="textButton" name="enterLogin" id="login" placeholder="login" type="text">
        <input class="textButton" name="enterPassword" placeholder="password" type="password"> <br>
        <input class="button" name="signIn" value="Sign in" id="loginBtn" type="submit">
    </form>
    <script src="js/main.js"></script>
</body>
</html>
