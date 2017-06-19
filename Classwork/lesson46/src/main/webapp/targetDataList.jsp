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
    <title>Target Data List</title>
    <meta charset="UTF-8">
</head>
<body>

    <table>
        <thead>
        <tr>
            <td>Email</td>
            <td>User Name</td>
        </tr>
        </thead>

        <tbody>
            <c:forEach var="td" items="${targetDataList}">
                <tr>
                    <td>
                        <c:out value="${td.email}"/>
                    </td>
                    <td>
                        <c:out value="${td.userName}"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>

</body>
</html>
