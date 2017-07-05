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
    <button id = "showAddForm" onclick="showAddForm()">Add user</button>
    <button id = "showFindForm" onclick="showFindForm()">Find user</button>
    <button id = "hideForm" onclick="hideForm()" hidden>Hide form</button>

    <div id = "addFindForm" style = "margin: 10px 0px 20px 0px" hidden>
        <p style = "margin: 10px 0px 20px 0px">Find user</p>
        <select id="findUser" size="1">
            <option value="findByEmail" selected> Find By Email </option>
            <option value="findPhone"> Find By Phone </option>
            <%--<button id="find" onclick="findUser(this)" >Edit</button>--%>
        </select>
        <input id = "filterData" type="text">

    </div>

    <div id = "addUserForm" style = "margin: 10px 0px 20px 0px" hidden>
        <p style = "margin: 10px 0px 20px 0px" id = "addNewUser">Add new user</p>
        <table cellspacing="0" id ="addUserFormTable">
            <thead><!-- <th scope="row"></th> -->
            <tr>
                <td id="new-login-column">Login</td>
                <td id="new-name-column">FullName</td>
                <td id="new-email-column">Email</td>
                <td id="new-phone-column">Phone</td>
                <td id="new-age-column">Age</td>
                <td id="new-password-column">Password</td>
                <td id="new-gender-column">Gender</td>
                <td id="new-roleUser-column" style="width: auto">Role</td>
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
                    <td name="age"> <input class="adminTextButton textButtonBorder" id="new-age" type="text"> </td>
                    <td name="password"> <input class="adminTextButton textButtonBorder" id="new-password" type="password" required> </td>
                    <td id="new-gender" style="width: 100px;">
                        <p><input name="new-gender" type="radio" value="MALE" checked> Male </p>
                        <p><input name="new-gender" type="radio" value="FEMALE"> Female </p>
                    </td>
                    <td name="new-roleUser" style="width: auto">
                        <select id="new-roleUser" size="1">
                            <option value="GUEST" selected> Guest </option>
                            <option value="ADMIN"> Admin </option>
                        </select>
                    </td>
                    <td style="width: auto">
                        <button id="addUser" name="add">Save</button>
                    </td>
                    <td style="width: auto">
                        <button id="cancelAddUser">Cancel</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <div style = "margin: 10px 0px 20px 0px" class="tableContainer">
        <p style = "margin: 10px 0px 20px 0px" id = "allUsers">All users table</p>
        <table cellspacing="0" id = "tableWithUsersData">
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
                    <td style="width: auto" id="roleUser-column">Role</td>
                    <td id="edit">Edit</td>
                    <td id="cancel-column">Cancel</td>
                </tr>
            </thead>

            <tbody id="user-table">
               <c:forEach var="v" items="${userListAll}">
                <tr>
                    <td <%--style="width: auto;"--%> name="id"> <p id = "id"> ${v.id} </p></td>
                    <td name="login">
                        <input class="adminTextButton" name="login" id="login" value="${v.login}" type="text" readonly>
                    </td>
                    <td name="fullName">
                        <input class="adminTextButton" name="fullName" id="name" value="${v.fullName}" type="text" disabled>
                    </td>
                    <td name="email">
                        <input class="adminTextButton" name="email" id="email" value="${v.email}" type="text" disabled required>
                    </td>
                    <td name="phone">
                        <input class="adminTextButton" name="phone" id="phone" value="${v.phoneNumber}" type="text" disabled required>
                    </td>
                    <td name="age">
                        <input class="adminTextButton" name="age" id="age" value="${v.age}" type="text" disabled>
                    </td>
                    <td>
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
                    </td>
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
            let requestParams = `login=${user.login}&email=${user.email}&age=${user.age}&user-roleUser=${user.roleUser}`;
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
            let roleUser = currentRow.querySelector('td[name="roleUser"]');
            let gender = currentRow.querySelector('td[name="gender"]');
            let user = getFormData();

            id.innerHTML = user.id;
            login.innerHTML = user.login;
            email.innerHTML = user.email;
            age.innerHTML = user.age;
            roleUser.innerHTML = user.roleUser;
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
            let roleUser = currentRow.querySelector('td[name="roleUser"]').innerHTML;
            let gender = currentRow.querySelector('td[name="gender"]').innerHTML;

            document.getElementById('id').value = id;
            document.getElementById('login').value = login;
            document.getElementById('email').value = email;
            document.getElementById('age').value = age;

            let roleSelect = document.getElementById('roleUser').options;
            for(let i = roleSelect.length - 1; i >= 0; i--) {
                let opt = roleSelect[i];

                if(roleUser === opt.innerHTML) {
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
            let roleSelect = document.getElementById('roleUser');
            let roleUser = roleSelect.options[roleSelect.selectedIndex].text;
            let gender = document.getElementById('gender').value;

            return {id, login, email, age, roleUser, gender};
        }
    </script>--%>
    <script src="js/admin.js"></script>
</body>
</html>
