<%--
  Created by IntelliJ IDEA.
  User: ravskiy
  Date: 15.05.2017
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ADMIN Info</title>
    <meta charset="UTF-8">
    <style>
        <%@include file='css/main.css' %>
        <%--<%@include file='js/main.js' %>--%>
    </style>

</head>
<body style="margin: 20px 2% 20px 2%;">
    <%--<img src="../css/black-diamond-logo.png"/>--%>

    <%--<div id="edit-form">
        <table class="table">
            <tr style="vertical-align: top;">
                <td><input type="text" id="id" placeholder="Id" name="id"></td>
                <td><input type="text" id="login" placeholder="Login" name="login"></td>
                <td><input type="email" id="email" placeholder="Email" name="email"></td>
                <td><input type="text" id="age" placeholder="Age" name="age"></td>
                <td>
                    <select id="role">
                        <option value="SIMPLE">User</option>
                        <option value="ADMIN">Administrator</option>
                    </select>
                </td>
                <td>
                    <div id="gender">
                        <option type="radio" name="gender" checked value="NOT_SPECIFIED">Not cpecified</option>
                        <p><option type="radio" name="gender" value="MALE">Male</option></p>
                        <p><option type="radio" name="gender" value="FEMALE">Female</option></p>
                        <&lt;%&ndash;select id="role">
                            <option value="MALE">Male</option>
                            <option value="FEMALE">Female</option>
                        </select>&ndash;%&gt;
                    </div>
            </tr>
				<span>
					<td><button hidden id="save-btn" onclick="saveUser(this)">Save</button></td>
				</span>
				<span>
					<td><button hidden id="send-btn" onclick="sendUser()">Send</button></td>
				</span>
        </table>
    </div>--%>

    <div id = "addUserForm" style = "margin: 10px 0px 20px 0px" hidden>
        <p style = "margin: 10px 0px 20px 0px" id = "addNewUser">Add new user</p>
        <table cellspacing="0">
            <thead><!-- <th scope="row"></th> -->
            <tr>
                <td id="new-login-column">Login</td>
                <td id="new-name-column">FullName</td>
                <td id="new-email-column">Email</td>
                <td id="new-phone-column">Phone</td>
                <td id="new-age-column">Age</td>
                <td id="new-password-column">Password</td>
                <td id="new-gender-column">Gender</td>
                <td id="new-role-column" style="width: auto">Role</td>
                <td id="new-save-column">Edit</td>
                <td id="new-cancel-column">Cancel</td>
            </tr>
            </thead>

            <tbody id="new-user-table">
                <tr>
                    <td name="login"> <input class="adminTextButton textButtonBorder" id="new-login" type="text" required> </td>
                    <td name="fullName"> <input class="adminTextButton textButtonBorder" id="new-fullName" type="text"> </td>
                    <td name="email"> <input class="adminTextButton textButtonBorder" id="new-email" type="text" required> </td>
                    <td name="phone"> <input class="adminTextButton textButtonBorder" id="new-phone" type="text" required> </td>
                    <td name="age"> <input class="adminTextButton textButtonBorder" name="age" id="new-age" type="text"> </td>
                    <td name="password"> <input class="adminTextButton textButtonBorder" id="new-password" type="password" required> </td>
                    <td id="gender" style="width: 100px;">
                        <p><input name="gender" type="radio" value="MALE" checked> Male </p>
                        <p><input name="gender" type="radio" value="FEMALE"> Female </p>
                    </td>
                    <td name="role" style="width: auto">
                        <select id="new-role" size="1">
                            <option value="USER" selected> User </option>
                            <option value="ADMIN"> Admin </option>
                        </select>
                    </td>
                    <td style="width: auto">
                        <button id="addUser" onclick="saveUser(this)">Save</button>
                    </td>
                    <td style="width: auto">
                        <button id="cancelAddUser" onclick="cancelUser(this)" >Cancel</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <button id = "showForm" onclick="showAddForm()">Add user</button>
    <button id = "hideForm" onclick="showAddForm()" hidden>Hide form</button>

    <div style = "margin: 10px 0px 20px 0px" class="tableContainer">
        <p style = "margin: 10px 0px 20px 0px" id = "allUsers">All users table</p>
        <table cellspacing="0">
            <thead><!-- <th scope="row"></th> -->
                <tr>
                    <td style="width: auto;" id="id-column">ID</td>
                    <td id="login-column">Login</td>
                    <td id="name-column">FullName</td>
                    <td id="email-column">Email</td>
                    <td id="phone-column">Phone</td>
                    <td id="age-column">Age</td>
                    <td id="password-column">Password</td>
                    <td id="gender-column">Gender</td>
                    <td style="width: auto" id="role-column">Role</td>
                    <td id="edit">Edit</td>
                    <td id="cancel-column">Cancel</td>
                </tr>
            </thead>

            <tbody id="user-table">
               <c:forEach var="v" items="${userListAll}">
                <tr>
                    <td <%--style="width: auto;"--%> name="id"> ${v.id} </td>
                    <td name="login">
                        <input class="adminTextButton" name="login" id="login" value="${v.login}" type="text" readonly>
                    </td>
                    <td name="fullName">
                        <input class="adminTextButton" name="fullName" id="name" value="${v.fullName}" type="text" disabled>
                    </td>
                    <td name="email">
                        <input class="adminTextButton" name="email" id="email" value="${v.email}" type="text" disabled>
                    </td>
                    <td name="phone">
                        <input class="adminTextButton" name="phone" id="phone" value="${v.phoneNumber}" type="text" disabled>
                    </td>
                    <td name="age">
                        <input class="adminTextButton" name="age" id="age" value="${v.age}" type="text" disabled>
                    </td>
                    <td>
                        <input class="adminTextButton" name="password" id="password" value="${v.password}" type="password" disabled>
                    </td>
                    <td style="width: 100px;" name="gender">
                        <p><input name="gender" type="radio" value="MALE"> Male </p>
                        <p><input name="gender" type="radio" value="FEMALE"> Female </p>
                    </td>
                    <td style="width: auto" name="role">
                        <select id="role" size="1" name="role">
                            <option value="USER" selected> User </option>
                            <option value="ADMIN"> Admin </option>
                        </select>
                    </td>
                    <td>
                        <button id="1" onclick="editUser(this)">Edit</button>
                        <button id="2" onclick="saveUser(this)" hidden >Save</button>
                    </td>
                    <td style="width: auto">
                        <button id="3" onclick="cancelUser(this)" >Cancel</button>
                    </td>
                </tr>
                </c:forEach>
            </tbody>

        </table>
    </div>




    <%--<form class="form" id = "change-form" action="/userpage" method="post">
        <c:set var="userFromJSP" value="${userList}" scope="session"/>
        <c:forEach var="v" items="${userList}">
            <p name="id" id="id"> ${v.id} </p>
            <input class="adminTextButton" name="login" id="login" value="${v.login}" type="text" readonly>
            <input class="adminTextButton" name="fullName" id="name" value="${v.fullName}" type="text" disabled>
            <input class="textButton" name="age" id="age" value="${v.age}" type="text" disabled>
            <input class="textButton" name="phone" id="phone" value="${v.phoneNumber}" type="text" disabled>
            <input class="textButton" name="email" id="email" value="${v.email}" type="text" disabled>
            <input class="textButton" name="password" id="password" value="${v.password}" type="password" disabled> <br>
            <a class="pointer" id="changePass" onclick="changePassword()">change password</a> <br><br>
        </c:forEach>

        <a class="button" href="<%=request.getServletContext().getContextPath()%>/userpage"> Home </a>
        <a class="button" id="changeUserData"> Change </a>
        <a class="button" id="save" hidden> Save </a>
        <a class="button" id="cancel" hidden> Cancel </a>
    </form>--%>

<%--    <script type="text/javascript">
        function showAddForm() {
            showEditForm();
            document.getElementById('send-btn').removeAttribute('hidden');
            document.getElementById('save-btn').setAttribute('hidden', true);
        }

        function sendUser() {
            let user = getFormData();
            let requestParams = `login=${user.login}&email=${user.email}&age=${user.age}&user-role=${user.role}`;
            let headers = new Headers({
                'Content-Type':'application/x-www-form-urlencoded'
                // 'Access-Control-Allow-Origin': '*'
            });

            fetch('http://localhost:8080/user/registration', {
                method: 'POST',
                headers,
                body: requestParams
            })
                    .then(function (response) {
                        console.log(response);
                    })
                    .catch(alert);
        }
        function saveUser() {
            let currentRow = document.querySelector('tr[in-editing]');

            currentRow.removeAttribute('in-editing');
            let id = currentRow.querySelector('td[name="id"]');
            let login = currentRow.querySelector('td[name="login"]');
            let email = currentRow.querySelector('td[name="email"]');
            let age = currentRow.querySelector('td[name="age"]');
            let role = currentRow.querySelector('td[name="role"]');
            let gender = currentRow.querySelector('td[name="gender"]');
            let user = getFormData();

            id.innerHTML = user.id;
            login.innerHTML = user.login;
            email.innerHTML = user.email;
            age.innerHTML = user.age;
            role.innerHTML = user.role;
            gender.innerHTML = user.gender;
        }

        function editUser(data) {
            showEditForm();
            let currentRow = data.parentNode.parentNode;
            currentRow.setAttribute('in-editing', '');
            let id = currentRow.querySelector('td[name="id"]').innerHTML;
            let login = currentRow.querySelector('td[name="login"]').innerHTML;
            let email = currentRow.querySelector('td[name="email"]').innerHTML;
            let age = currentRow.querySelector('td[name="age"]').innerHTML;
            let role = currentRow.querySelector('td[name="role"]').innerHTML;
            let gender = currentRow.querySelector('td[name="gender"]').innerHTML;

            document.getElementById('id').value = id;
            document.getElementById('login').value = login;
            document.getElementById('email').value = email;
            document.getElementById('age').value = age;

            let roleSelect = document.getElementById('role').options;
            for(let i = roleSelect.length - 1; i >= 0; i--) {
                let opt = roleSelect[i];

                if(role === opt.innerHTML) {
                    roleSelect[i].selected = true
                } else roleSelect[i].selected = false;
            }
        }

        function showEditForm() {
            document.getElementById('edit-form').removeAttribute('hidden');
        }

        function getFormData() {
            let id = document.getElementById('id').value;
            let login = document.getElementById('login').value;
            let email = document.getElementById('email').value;
            let age = document.getElementById('age').value;
            let roleSelect = document.getElementById('role');
            let role = roleSelect.options[roleSelect.selectedIndex].text;
            let gender = document.getElementById('gender').value;

            return {id, login, email, age, role, gender};
        }
    </script>--%>

    <script src="js/admin.js"></script>
</body>
</html>
