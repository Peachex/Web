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
<div class="container">
    <div class="mb-3 row col-4 offset-4 header" style="margin-top: 1%;">Users info:</div>
    <div class="row">
        <hr style="color:#0d6efd;;" size="5"/>
    </div>
    <div class="row col-10 offset-1" style="display: flex; justify-content: center; color: grey;">${users}</div>
    <div class="mb-5 row">
        <hr style="color:#0d6efd;;" size="5"/>
    </div>

    <div class="mb-3 row">
        <div class="col-4 offset-5">
            <form name="signIn" method="POST" action="controller">
                <input type="hidden" name="command" value="redirect_to_sign_in"/>
                <button class="btn btn-primary button" type="submit">Back</button>
            </form>
        </div>
    </div>
</div>
<style>
    body {
        background-color: rgba(255, 255, 255, 0.60);
    }

    .header {
        font-size: 30px;
        color: darkgrey;
        display: flex;
        justify-content: center;
    }

    .button {
        width: 50%;
    }
</style>
</body>
</html>
