<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 02.06.17
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
html>
<head>
  <title>User info</title>
</head>
<body>


<img src="/resources/photo_not_available.png" alt="User avatar">

<input id="user-avatar" type="file">
<button onclick="uploadFile()">Upload</button>

<script>

  function uploadFile() {
    var input = document.querySelector('input[type="file"]');

    var data = new FormData();
    data.append('file', input.files[0]);

    console.log("send document with size:" + input.files[0].size + "b to server");
    fetch('http://localhost:8080/user/avatar', {
      method: 'POST',
      body: data
    })
        .then(response => console.log(response))
  .catch(error => console.error(error));


//    let file = document.getElementById("user-avatar").files[0];
//
//    fetch("http://localhost:8080/user/avatar",
//          {
//            headers: new Headers({
//              "Content-Type": "multipart/form-data"
//            }),
//            method: "post",
//            body: file
//          }
//    )
//        .then(response => response.json())
//  .then(function(response) {
//      console.log(response);
//    })
//       .catch(error => console.error(error))

  }
</script>

</body>
</html>
