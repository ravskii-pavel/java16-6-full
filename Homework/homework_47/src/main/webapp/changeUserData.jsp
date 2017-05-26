<%--
  Created by IntelliJ IDEA.
  User: Ravskiy Pavel
  Date: 26.05.2017
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Change User Data</title>
    <meta charset="UTF-8">
    <style>
        <%@include file='css/main.css' %>
    </style>

</head>
<body style="margin: 20px 35% 20px 35%;">
<img src="../css/black-diamond-logo.png"/>
<div class="form">
    <c:forEach var="v" items="${userList}">



    </c:forEach>

    <a class="button" href="<%=request.getServletContext().getContextPath()%>/"> Home </a>
    <a class="button" href="<%=request.getServletContext().getContextPath()%>/"> Change </a>
</div>

</body>
</html>