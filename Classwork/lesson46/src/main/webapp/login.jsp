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
    <title>Login</title>
</head>
<body>

<img src="<c:url value="/images/login-img.png"/>" alt="login preview">

    <form action="<%=request.getServletContext().getContextPath()%>/welcome" method="post">
        <input name="login" type="text">
        <input name="password" type="password">
        <input type="submit" value="Login">
    </form>

</body>
</html>
