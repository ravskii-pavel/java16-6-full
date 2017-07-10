<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 07.07.2017
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add movie session</title>
</head>
<body>

<form action="/movie/add-session" method="post">
    <input type="text" name="filmId" id="filmId">
    <input type="text" name="sessionStartDate" id="sessionStartDate">
    <input type="text" name="sessionStartTime" id="sessionStartTime">
    <input type="text" name="hallNumber" id="hallNumber">
    <input type="text" name="standardTicketPrice" id="standardTicketPrice">
    <input type="text" name="comfortTicketPrice" id="comfortTicketPrice">

    <input type="submit" value="Add">
    <button onclick="history.back()">Cancel</button>
</form>

</body>
</html>
