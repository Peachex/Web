<%--
  Created by IntelliJ IDEA.
  User: Peachex
  Date: 12/25/2020
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <title>Sign Up</title>
</head>
<body>

<h2>Sign up:</h2>
<hr style="color:#0d6efd;;" size="5"/>
<form name="signUpForm" method="POST" action="controller">
    <input type="hidden" name="command" value="sign_up"/>
    <div class="mb-3 row">
        <label for="inputLogin" class="col-sm-2 col-form-label textBeforeField">Login</label>
        <div class="col-sm-10">
            <input type="text" class="form-control field" id="inputLogin" name="login"
                   placeholder="Must have at least 2 characters" required
                   pattern="^[A-Za-zА-яа-я0-9_]{2,20}$">
        </div>
    </div>
    <p>${errorLoginName}</p>
    <g>Proper format: john_25</g>
    <div class="mb-3 row">
        <label for="inputPassword" class="col-sm-2 col-form-label textBeforeField">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control field" id="inputPassword" name="password"
                   placeholder="Must have at least 4 characters" required
                   pattern="^[A-Za-z0-9_]{4,20}$">
        </div>
    </div>
    <c>Proper format: 1j2o3h4n5_25</c>
    <div class="mb-3 row">
        <label for="inputPassword" class="col-sm-2 col-form-label textBeforeField">Repeat password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control field" id="repeatPassword" name="rePassword"
                   required
                   pattern="^[A-Za-z0-9_]{4,20}$">
        </div>
    </div>
    <p>${errorPasswordRepeat}</p>
    <br/>
    <div style="margin-top: -62px;
    margin-bottom: 66px;" class="d-grid gap-2 col-6 mx-auto">
        <button class="btn btn-primary button" type="submit">Sign up</button>
    </div>
</form>
<form name="SignIn" method="POST" action="controller">
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
        display: flex;
        color: red;
        justify-content: center;
    }

    c {
        display: flex;
        color: grey;
        justify-content: center;
        margin-left: 580px;
        font-style: italic;
        margin-top: -33px;
    }

    g {
        display: flex;
        color: grey;
        justify-content: center;
        margin-left: 560px;
        margin-top: -50px;
        font-style: italic;
    }

    h2 {
        display: flex;
        margin-top: 15px;
        justify-content: center;
    }

    .textBeforeField {
        padding-left: 953px;
        padding-top: 28px;
    }

    .field {
        margin-top: 10px;
        margin-bottom: -15px;
        width: 285px;
        margin-left: 823px;
        display: flex;
        justify-content: center;
    }

    .col-6 {
        display: flex;
        justify-content: center;
        padding-top: 20px
    }

    .button {
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
