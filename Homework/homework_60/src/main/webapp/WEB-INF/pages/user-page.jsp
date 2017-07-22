<%--
  Created by IntelliJ IDEA.
  User: ravskiy
  Date: 13.07.17
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<div>User Page</div>
<f:out value="${auth}">
    <%--${film.id}
    ${film.name}
    ${film.description}
    ${film.duration}--%>

</f:out>
</body>
</html>
