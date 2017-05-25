<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 12.05.2017
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>

<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "b" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Main Page</title>
    <style>
        <%@include file='css/main.css' %>
    </style>
</head>
<body style="margin: 20px 35% 20px 35%;">
        <%--<img src="../${pageContext.request.contextPath}/css/black-diamond-logo.png"/>--%>
        <div class="form">
            <div class="legend">Вход в систему</div>
            <a class="button" href="<%=request.getServletContext().getContextPath()%>/login"> Sign in </a>
            <%-- <a class="button" href="<%=request.getServletContext().getContextPath()%>/registration"> Registration </a>--%>
        </div>
</body>
</html>
