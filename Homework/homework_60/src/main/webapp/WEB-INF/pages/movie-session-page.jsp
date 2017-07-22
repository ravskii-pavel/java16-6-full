<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 04.07.2017
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page import="java.util.Calendar" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>MovieSessions</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/main.css"/>

</head>
<body>

    <h1>MovieSession list:</h1>

    <%--<c:forEach var="session" items="${allMovieSessions}">--%>
            <%--<span><fmt:formatDate pattern="yyyy-MM-dd" value="${session.sessionStartDate.time}" />|</span>--%>
            <%--<span><fmt:formatDate pattern="HH-mm-ss" value="${session.sessionStartTime.time}" />|</span>--%>
        <%--&lt;%&ndash;<span><fmt:formatDate pattern="yyyy-MMM-EE" value="${session.sessionStartDate.time}" />|</span>&ndash;%&gt;--%>
    <%--</c:forEach>--%>

    <%--<img src="../css/black-diamond-logo.png"/>--%>
    <button id = "showAddForm" onclick="showAddForm()">Add session</button>
    <button id = "showFindForm" onclick="showFindForm()">Find session</button>
    <button id = "hideForm" onclick="hideForm()" hidden>Hide form</button>

    <div id = "addFindForm" style = "margin: 10px 0px 20px 0px" hidden>
        <p style = "margin: 10px 0px 20px 0px">Find MovieSession</p>
        <select id="findMovieSession" size="1">
            <option value="findByFilmName" selected> Find By Film Name </option>
            <%--<option value="findPhone"> Find By Phone </option>--%>
            <%--<button id="find" onclick="findUser(this)" >Edit</button>--%>
        </select>
        <input id = "filterData" type="text">

    </div>

    <div id ="addSessionForm" style = "margin: 10px 0px 20px 0px" hidden>
        <p style = "margin: 10px 0px 20px 0px" id = "addNewUser">Add new user</p>
        <form action="/movie-session/list" method="post">
        <table cellspacing="0" id ="addSessionFormTable">
            <thead><!-- <th scope="row"></th> -->
            <tr>
                <td id="new-film-id-column">Film ID</td>
                <td id="new-hall-id-column">Hall ID</td>
                <td id="new-standard-price-column">Standard Price</td>
                <td id="new-comfort-price-column">Comfort Price</td>
                <td id="new-date-column">Date</td>
                <td id="new-time-column">Time</td>
                <td id="new-save-column">Save</td>
                <td id="new-cancel-column">Cancel</td>
            </tr>
            </thead>

            <tbody id="new-user-table">
            <tr>
                <td name="film-id"> <input class="adminTextButton textButtonBorder" name="newFilmId" id="newFilmId" type="text" required> </td>
                <td name="hall-id"> <input class="adminTextButton textButtonBorder" name="newHallId" id="newHallId" type="text"> </td>
                <td name="standard-price"> <input class="adminTextButton textButtonBorder" name="newStandardPrice" id="newStandardPrice" type="text" required> </td>
                <td name="comfort-price"> <input class="adminTextButton textButtonBorder" name="newComfortPrice" id="newComfortPrice" type="text" required> </td>
                <td name="date"> <input class="adminTextButton textButtonBorder" name="newDate" id="newDate" type="date"> </td>
                <td name="time"> <input class="adminTextButton textButtonBorder" name="newTime" id="newTime" type="time" required> </td>
                <td style="width: auto">
                    <input id="addSession" name="add" type="submit" value="Add">
                </td>
                <td style="width: auto">
                    <button id="cancelAddSession" onclick="history.back()">Cancel</button>
                </td>
            </tr>
            </tbody>
        </table>
        </form>
    </div>

    <div style = "margin: 10px 0px 20px 0px" class="tableContainer">
        <p style = "margin: 10px 0px 20px 0px" id = "allMovieSessions">All Movie Sessions</p>
        <table cellspacing="0" id = "tableWithSessionData">
            <thead><!-- <th scope="row"></th> -->
            <tr>
                <td style="width: auto;" id="id-column">ID</td>
                <td id="film-id-column">Film ID</td>
                <td id="film-name-column">Film Name</td>
                <td id="hall-name-column">Hall Name</td>
                <td id="standard-price-column">Standard Price</td>
                <td id="comfort-price-column">Comfort Price</td>
                <td id="date-column">Date</td>
                <td id="time-column">Time</td>
                <td id="edit">Edit</td>
                <td id="cancel-column">Cancel</td>
            </tr>
            </thead>

            <tbody id="session-table">
            <c:forEach var="session" items="${allMovieSessions}">
                <tr>
                    <td name="id"> <p id="id"> ${session.id} </p></td>
                    <td name="filmId"> <p id="filmId"> ${session.film.id} </p></td>
                    <td name="filmName"> <p id="filmName"> ${session.film.name} </p></td>
                    <td name="hallName">
                        <input class="adminTextButton" name="hallName" id="hallName" value="${session.hall.hallName}" type="text" disabled>
                    </td>
                    <td name="priceStandard">
                        <input class="adminTextButton" name="priceStandard" id="priceStandard" value="${session.priceTicketStandard}" type="text" disabled required>
                    </td>
                    <td name="priceComfort">
                        <input class="adminTextButton" name="priceComfort" id="priceComfort" value="${session.priceTicketComfort}"
                        type="text" disabled required>
                    </td>
                    <td name="dateStart">
                        <input class="adminTextButton" name="dateStart" id="dateStart" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${session.sessionStartDate.time}'/>"
                        type="date" required>
                    </td>
                    <td name="time" >
                        <input class="adminTextButton" name="time" id="time" value="<fmt:formatDate pattern='HH-mm-ss' value='${session.sessionStartTime.time}'/>"
                        type="time" required>
                    </td>


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
                    <td>
                        <button id="editUser" onclick="editUser(this)" >Edit</button>
                        <button id="saveEditUser" onclick="saveEditUser(this)" name="update" hidden >Update</button>
                    </td>
                    <td style="width: auto">
                        <button id="cancelEditUser" onclick="cancelEditUser(this)" hidden>Cancel</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/admin.js"></script>

</body>
</html>
