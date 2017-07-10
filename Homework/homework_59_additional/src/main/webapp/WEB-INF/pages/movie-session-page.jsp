<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 04.07.2017
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movies</title>
</head>
<body>

<h1>Movie list:</h1>
<div>
    movieSessionId|filmId|sessionStartDate|sessionStartTime|hallNumber|standardTicketPrice|comfortTicketPrice
</div>
<c:forEach var="session" items="${allMovieSessions}">
    <div>
        <span>${session.movieSessionId}|</span>
        <span>${session.filmId}|</span>
        <span>${session.sessionStartDate}|</span>
        <span>${session.sessionStartTime}|</span>
        <span>${session.hallNumber}|</span>
        <span>${session.standardTicketPrice}|</span>
        <span>${session.comfortTicketPrice}</span>
    </div>
</c:forEach>

</body>
</html>
