<%--
  Created by IntelliJ IDEA.
  User: Peachex
  Date: 12/23/2020
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <title>Users Info</title>
</head>
<body>
<h2>Users info:</h2>
<hr style="color:#0d6efd;;" size="5"/>
<p>${users}</p>
<hr style="color:#0d6efd;;" size="5"/>
<form name="signIn" method="POST" action="controller">
    <input type="hidden" name="command" value="redirect_to_sign_in"/>
    <div class="d-grid gap-2 col-6 mx-auto">
        <button class="btn btn-primary button" type="submit">Back</button>
    </div>
</form>
<style>
    body {
        background-color: rgba(255, 255, 255, 0.60);
    }

    p {
        margin-block: 80px;
        font-size: 30px;
        display: flex;
        color: darkgrey;
        justify-content: center;
        margin-top: 65px;
    }

    g {
        display: flex;
        color: green;
        justify-content: center;
    }

    h2 {
        display: flex;
        margin-top: 15px;
        justify-content: center;
    }

    .col-6 {
        display: flex;
        justify-content: center;
        padding-top: 20px
    }

    .button {
        margin-block: 30px;
        margin-bottom: -150px;
        margin-top: 110px;
        margin-left: 15px;
        display: flex;
        justify-content: center;
        width: 237px;
    }
</style>
</body>
</html>
