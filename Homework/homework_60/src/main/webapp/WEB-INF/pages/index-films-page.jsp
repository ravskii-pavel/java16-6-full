
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.GregorianCalendar" scope="page"/>
<html>
<head>
    <title>All Films</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/main.css"/>

</head>
<body>

<div style = "margin: 10px 0px 20px 0px" class="tableContainer">
    <p style = "margin: 10px 0px 20px 0px" id = "allFilms">All Films</p>
    <table cellspacing="0" id = "tableWithSessionData">
        <thead><!-- <th scope="row"></th> -->
        <tr>
            <td style="width: auto;" id="id-column">ID</td>
            <td id="name-column">Film Name</td>
            <td id="description-column">Description</td>
            <td id="duration-column">Duration</td>
            <td id="sessions-data-column">SessionDate</td>
            <td id="sessions-time-column">SessionTime</td>
        </tr>
        </thead>

        <tbody id="session-table">
        <c:forEach var="film" items="${allFilms}">
            <tr>
                <td name="filmId"> <p id="filmId"> ${film.id} </p></td>
                <td name="filmName"> <p id="filmName"> ${film.name} </p></td>
                <td name="filmDescription"> <p id="filmDescription"> ${film.description} </p></td>
                <td name="filmDuration"> <p id="filmDuration"> ${film.duration} </p></td>

                <c:forEach var="session" items="${film.sessionList}">
                    <td name="filmSessionData">
                        <input class="adminTextButton" name="sessionDataFilm" type="date" id="sessionDataFilm"
                               min="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${now.time}'/>"
                               value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${session.sessionStartDate.time}'/>"
                               required>
                    </td>
                    <td name="filmSessionTime">
                        <input class="adminTextButton" name="sessionTimeFilm" type="time" id="sessionTimeFilm"
                               step="60" <%--min="<fmt:formatDate pattern='HH:mm:ss' type='time' value='${now.time}'/>"--%>
                               value="<fmt:formatDate pattern='HH:mm' type='time' value='${session.sessionStartTime.time}'/>"
                               required>
                        <%--<p>${now.time}</p>--%>
                    </td>
                </c:forEach>

                    <%--<td>
                        <input class="adminTextButton" name="password" id="password" value="${v.password}" type="password" disabled required>
                    </td>
                    <td style="width: 100px;">
                        <div id = "genderName" >${v.gender}</div>
                        <div id="gender" hidden>
                            <p><input name="gender" type="radio" value="MALE"> Male </p>
                            <p><input name="gender" type="radio" value="FEMALE"> Female </p>
                        </div>
                    </td>
                    <td style="width: auto">
                        <div id = "roleUserName">${v.roleUser}</div>
                        <select id = "roleUser" size="1" name="roleUser" hidden>
                            <option value="GUEST"> Guest </option>
                            <option value="ADMIN"> Admin </option>
                        </select>
                    </td>--%>
                <%--<td>
                    <button id="editUser" onclick="editUser(this)" >Edit</button>
                    <button id="saveEditUser" onclick="saveEditUser(this)" name="update" hidden >Update</button>
                </td>
                <td style="width: auto">
                    <button id="cancelEditUser" onclick="cancelEditUser(this)" hidden>Cancel</button>
                </td>--%>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

</body>
</html>
