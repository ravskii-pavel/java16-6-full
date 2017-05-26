<%--
  Created by IntelliJ IDEA.
  User: ravskiy
  Date: 15.05.2017
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Info</title>
    <meta charset="UTF-8">
    <style>
        <%@include file='css/main.css' %>
        <%--<%@include file='js/main.js' %>--%>
    </style>

</head>
<body style="margin: 20px 35% 20px 35%;">
    <img src="../css/black-diamond-logo.png"/>
    <form class="form" id = "change-form">
        <c:forEach var="v" items="${userList}">
            <input class="textButton" name="login" id="login" value="${v.login}" type="text" disabled>
            <input class="textButton" name="fullName" value="${v.fullName}" type="text" disabled>
            <input class="textButton" name="age" value="${v.age}" type="text" disabled>
            <input class="textButton" name="phone" value="${v.phoneNumber}" type="text" disabled>
            <input class="textButton" id="email" name="email" value="${v.email}" type="text" disabled>
            <input class="textButton" name="password" type="password" disabled> <br>
            <a href="<%=request.getServletContext().getContextPath()%>/changepass">change password</a> <br>

        </c:forEach>

        <a class="button" href="<%=request.getServletContext().getContextPath()%>/"> Home </a>
        <a class="button" id="changeUserData"> Change </a>
        <input class="button" id ="save" name="signIn" value="Save" type="submit" hidden>
        <a class="button" id="cancel" hidden> Cancel </a>
    </form>

    <script src="js/main.js"></script>
</body>
</html>
