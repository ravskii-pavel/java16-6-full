<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 12.05.2017
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <style>
        <%@include file='css/main.css' %>
    </style>
</head>
<body style="margin: 20px 35% 20px 35%;">

    <form class="form" action="/login" method="post">
        <div class="legend">${enterSystem}</div>
        <input class="textButton" name="enterEmail" placeholder="email" type="text">
        <input class="textButton" name="enterPassword" placeholder="password" type="password"> <br>
        <input class="button" name="signIn" value="Sign in"  type="submit">
    </form>

</body>
</html>
