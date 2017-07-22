<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "d" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="now" class="java.util.GregorianCalendar" scope="page"/>
<html>
<head>
    <title>Management Hall</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/film.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/hall.css"/>
</head>
<body>
<div class="wrapper">
    <header class="top-column">
        <div>
            <a href="/" class="logo"><img src="" alt=""/>LOGO</a>
        </div>
        <nav class="head-menu">
            <ul>
                <li><a href="page1.html">Страница 1</a></li>
                <li><a href="page2.html">Страница 2</a></li>
                <li><a href="page3.html">Страница 3</a></li>
            </ul>
        </nav>
        <div class="authorization">
            <%--<c:if test="${auth.email != '0'}">
                <c:out value="${auth.email}" />
            </c:if>--%>
            <d:choose>
                <d:when test="${auth.email != null}">
                    <a id="auth-user" href="#">${auth.email}</a>
                    <a id="exit-user" href="#">Exit</a>
                </d:when>
                <d:otherwise>
                    <a id="sign-in" href="#">Sign in</a>
                    <a id="authorization" href="#">Authorization</a>
                </d:otherwise>
            </d:choose>
        </div>
    </header>
    <aside class="left-col">
        <nav>
            <ul>
                <li><a href="page1.html">Страница 1</a></li>
                <li><a href="page2.html">Страница 2</a></li>
                <li><a href="page3.html">Страница 3</a></li>
            </ul>
        </nav>
    </aside>
    <main class="right-col">

        <section>
            <h1>HALLS</h1>
            <br><br>
            <%--<d:out value="${film}">  </d:out>--%>
            <%-- <input class="adminTextButton" name="sessionDataFilm" type="datetime-local" id="sessionDataFilm"
                           min="<fmt:formatDate pattern='yyyy-MM-dd\'T\'HH:mm' type="both" value='${now.time}'/>"
                           value="<fmt:formatDate pattern='yyyy-MM-dd\'T\'HH:mm' type='both'
                                             value='${session.sessionStartDate.time}'/>"required>  action="${pageContext.servletContext.contextPath}/admin/halls/create-rows" --%>
            <form:form class="" action="#" method="post" onsubmit="return createHall()">
                <div id = "add-hall" class="add-halls">
                    <input id="hall-name" type="text" name="hallName" placeholder="hall name" maxlength="15" pattern="[a-zA-Z0-9]{4,}" required>
                    <input id="quantity-rows" type="number" name="quantityRowsInHall" placeholder="quantity rows in hall" maxlength="2" value="1"  min="1" max="99" required>
                    <input type="submit" id="create-hall" value="Add Hall"/>
                </div>
                <div id="add-rows" hidden>

                </div>
            </form:form>
            <%--<section id="get-halls" hidden>
                <form:form class="" action="${pageContext.servletContext.contextPath}/admin/halls/change" method="post">
                    <d:forEach var="hall" items="${allHalls}">
                        <div class="get-halls">
                            <input type="text" NAME: ${hall.hallName}/>
                            <span>ROWS: ${hall.quantityRows}</span>
                            <input type="submit" id="${hall.id}" value="change">
                        </div>
&lt;%&ndash;                        <d:forEach var="seat" items="${row.seatList}">
                               </d:forEach>&ndash;%&gt;
                    </d:forEach>
                </form:form>
            </section>--%>
        </section>
        <section>
            <d:choose>
                <d:when test="${auth.id != '0'}">
                    <d:out value="${auth}"></d:out>
                </d:when>
                <d:otherwise></d:otherwise>
            </d:choose>
        </section>
    </main>
    <div id="form-container" class="form-container" hidden>
        <form id="login-form" class="auth-form" action="${pageContext.servletContext.contextPath}/user" method="post" hidden>
            <input id="userEmail" name="userEmail" type="email" placeholder="email" required>
            <input id="userPass" name="userPass" type="password" placeholder="password" required>
            <input type="submit" value="ok">
        </form>
        <form id="auth-form" class="auth-form" action="" hidden>
            <input type="email" placeholder="email" required>
            <input type="password" placeholder="password" required>
            <input type="tel" placeholder="phone" required>
            <input type="text" placeholder="name" >
        </form>
        <button id="remove-form" id="remove-form" onClick="removeForm()">Cancel</button>
    </div>
    <footer>
        <p>Копирайты</p>
    </footer>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/hall.js"></script>
</body>
</html>
<%--<input class="adminTextButton" name="sessionTimeFilm" type="time" id="sessionTimeFilm"--%>
<%--step="60"&lt;%&ndash; min="<fmt:formatDate pattern='HH:mm:ss' type='time' value='${now.time}'/>"&ndash;%&gt;--%>
<%--value="<fmt:formatDate pattern='HH:mm' type='time' value='${session.sessionStartTime.time}'/>"--%>
<%--required>--%>
<%--pattern='yyyy-MM-dd HH:mm:ss' var='changedDate' dateStyle = 'medium' timeStyle = 'medium'  --%>

<%--<p>${fn:length(film.sessionList}</p>--%>
<%--<d:forEach var="uDate" items="${uniqueDates}">
    <fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${uDate.time}' var="uniqueDate"/>
    <p>${uniqueDate}</p>
    <d:forEach var="session" items="${film.sessionList}">
        <fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${session.sessionStartDate.time}' var="sessionDate"/>
        <fmt:formatDate pattern='HH:mm' type='time' value='${session.sessionStartDate.time}' var="sessionTime"/>
        <d:choose>
            <d:when test="${sessionDate == uniqueDate}">
                <div style="float: left; margin: 10px;">
                    <p><a href="${pageContext.servletContext.contextPath}/movie-session/${session.id}">${sessionTime}</a></p>
                </div>
                &lt;%&ndash;<d:out value="${auth}"></d:out>&ndash;%&gt;
            </d:when>
            <d:otherwise></d:otherwise>
        </d:choose>

    </d:forEach>
    <br>
    &lt;%&ndash;<d:out value="${uDate.sessionStartDate.time}"></d:out></p>&ndash;%&gt;
    &lt;%&ndash; <p><d:out value="${uDate.time}"></d:out></p>&ndash;%&gt;
</d:forEach>--%>