<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 23.05.2017
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<html>
<head>
    <title>Registration</title>

    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div>
    <!--</form>-->

    <form class="form-horizontal" action='<%=request.getServletContext().getContextPath()%>' method="POST">
        <fieldset>
            <div id="legend">
                <legend class="">Register</legend>
            </div>

            <div class="control-group">
                <!-- Username -->
                <label class="control-label" for="login">Login</label>

                <div class="controls">
                    <input type="text" id="login" name="login" placeholder="Enter you login here" class="input-xlarge">

                    <p class="help-block">Login can contain any letters or numbers, without spaces</p>
                </div>
            </div>

            <div class="control-group">
                <!-- E-mail -->
                <label class="control-label" for="email">E-mail</label>

                <div class="controls">
                    <input type="text" id="email" name="email" placeholder="" class="input-xlarge">

                    <p class="help-block">Please provide your E-mail</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Password-->
                <label class="control-label" for="password">Password</label>

                <div class="controls">
                    <input type="password" id="password" name="password" placeholder="" class="input-xlarge">

                    <p class="help-block">Password should be at least 4 characters</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Password -->
                <label class="control-label" for="password_confirm">Password (Confirm)</label>

                <div class="controls">
                    <input type="password" id="password_confirm" name="password_confirm" placeholder=""
                           class="input-xlarge">

                    <p class="help-block">Please confirm password</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Password -->
                <label class="control-label" for="user-role">User role</label>

                <div id="user-role">
                    <div class="controls">
                        <span>Admin</span><input type="radio" id="user-role-admin" name="user-role" placeholder=""
                                                 class="input-xlarge" value="ADMIN">

                        <span>Simple</span><input type="radio" id="user-role-simple" name="user-role" placeholder=""
                                                  class="input-xlarge" value="SIMPLE" checked>
                    </div>
                </div>
            </div>
            <div class="control-group">
                <!-- Password -->
                <label class="control-label" for="lang">Language</label>


                <div class="controls">
                    <select name="lang" id="lang">
                        <option value="EN">EN</option>
                        <option value="RU">RU</option>
                        <option value="UA">UA</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success">Register</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>


<script src="registration.js"></script>

</body>
</html>

</body>
</html>
