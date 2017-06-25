<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 02.06.2017
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info </title>
</head>
<body>

<img src="/resources/avatar.jpg" alt="avatar">

<input id="user-avatar" type="file">

<button onclick="uploadFile()">Upload</button>

<script>
    function uploadFile(){
        var file = document.getElementById("user-avatar");

        fetch("http://localhost:8080/user/avatar",
                {
                    headers: new Headers ({
                        "Content-Type": "multipart/form-data"
                    }),
                    method: "post",
                    body: file
                })
                .then(response => response.json())
                .then(function(response){
                    console.log(response);
        })
                .catch(error => console.error(error){}
    }
</script>

</body>
</html>
