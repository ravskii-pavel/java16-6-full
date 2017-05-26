<%--
  Created by IntelliJ IDEA.
  User: oshegeda
  Date: 19.05.2017
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>User table</title>
</head>
<body>

<div>
  <input type="text" id="user-search"/><span><button onclick="search()">Search</button></span>
</div>

<table>
  <thead>
  <tr>
    <td>Id</td>
    <td>Login</td>
    <td>Email</td>
    <td>First name</td>
    <td>Last name</td>
    <td>Age</td>
    <td>Address</td>
  </tr>
  </thead>
  <tbody id="user-table">
  <%--<c:forEach var="user" items="${userList}">--%>
    <%--<tr>--%>
      <%--<td>--%>
        <%--<c:out value="${user.id}"/>--%>
      <%--</td>--%>
      <%--<td>--%>
        <%--<c:out value="${user.login}"/>--%>
      <%--</td>--%>
      <%--<td>--%>
        <%--<c:out value="${user.email}"/>--%>
      <%--</td>--%>
      <%--<td>--%>
        <%--<c:out value="${user.userDetails.firstName}"/>--%>
      <%--</td>--%>
      <%--<td>--%>
        <%--<c:out value="${user.userDetails.lastName}"/>--%>
      <%--</td>--%>
      <%--<td>--%>
        <%--<c:out value="${user.userDetails.age}"/>--%>
      <%--</td>--%>
      <%--<td>--%>
        <%--<c:out value="${user.address.country}, ${user.address.city}, ${user.address.street}, ${user.address.houseNumber}"/>--%>
      <%--</td>--%>
    <%--</tr>--%>
  <%--</c:forEach>--%>
  </tbody>
</table>

<script src="/js/userTable.js"></script>
</body>
</html>
