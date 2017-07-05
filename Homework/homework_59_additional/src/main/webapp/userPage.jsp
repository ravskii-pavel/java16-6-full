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
<body style="margin: 20px 20% 20px 20%;">
    <img src="../css/black-diamond-logo.png"/>
    <form class="form" id = "change-form" action="/userpage" method="post">
         <%--<c:set var="w" value="${userListSession}" scope="session" />--%>
            <c:forEach var="v" items="${userList}">
                <p name="id" id="id" value="${v.id}"> ${v.id} </p>
                <input class="textButton" name="login" id="login" value="${v.login}" type="text" readonly>
                <input class="textButton" name="fullName" id="name" value="${v.fullName}" type="text" disabled>
                <input class="textButton" name="age" id="age" value="${v.age}" type="text" disabled>
                <input class="textButton" name="phone" id="phone" value="${v.phoneNumber}" type="text" disabled>
                <input class="textButton" name="email" id="email" value="${v.email}" type="text" disabled>
                <input class="textButton" name="password" id="password" value="${v.password}" type="password" disabled> <br>
                <a class="pointer" id="changePass" onclick="changePassword()">change password</a> <br><br>
            </c:forEach>
        <a class="button" href="<%=request.getServletContext().getContextPath()%>/userpage"> Home </a>
        <a class="button" id="changeUserData"> Change </a>
        <a class="button" id="save" hidden> Save </a>
        <a class="button" id="cancel" href="<%=request.getServletContext().getContextPath()%>/userpage" hidden> Cancel </a>
    </form>

    <script src="js/user.js"></script>
</body>
</html>
