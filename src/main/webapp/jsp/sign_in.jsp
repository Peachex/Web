<%--
  Created by IntelliJ IDEA.
  User: Peachex
  Date: 12/23/2020
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${currentLocale}"/>
<fmt:setBundle basename="locale.page_content"/>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <title><fmt:message key="login.pageTitle"/></title></head>
<body>
<h2><fmt:message key="login.pageTitle"/></h2>
<hr style="color:#0d6efd;;" size="5"/>
<form style="margin-bottom: -50px;" name="signInForm" method="POST" action="controller">
    <input type="hidden" name="command" value="sign_in"/>
    <div class="mb-3 row">
        <label for="inputLogin" class="col-sm-2 col-form-label textBeforeField">Login</label>
        <div class="col-sm-10">
            <input type="text" class="form-control field" id="inputLogin" name="login" value="" required
                   pattern="^[A-Za-zА-яа-я0-9_]{2,20}$">
        </div>
    </div>
    <div class="mb-3 row">
        <label for="inputPassword" class="col-sm-2 col-form-label textBeforeField">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control field" id="inputPassword" name="password" required
                   pattern="^[A-Za-z0-9_]{2,20}$">
        </div>
    </div>
    <br/>
    <p>${errorLoginPassMessage}</p>
    <br/>
    <p>${wrongAction}</p>
    <br/>
    <p>${nullPage}</p>
    <br/>
    <div style="margin-top: -62px;
    margin-bottom: 66px;" class="d-grid gap-2 col-6 mx-auto">
        <button class="btn btn-primary button" type="submit">Sign in</button>
    </div>
</form>

<form name="SignUp" method="POST" action="controller">
    <input type="hidden" name="command" value="redirect_to_sign_up"/>
    <div class="d-grid gap-2 col-6 mx-auto">
        <button class="btn btn-primary button" type="submit">Sign up</button>
    </div>
</form>
<form name="UsersInfoForm" method="POST" action="controller">
    <input type="hidden" name="command" value="user_info"/>
    <div class="d-grid gap-2 col-6 mx-auto">
        <button class="btn btn-primary button" type="submit">See users</button>
    </div>
    <style>
        body {
            background-color: rgba(255, 255, 255, 0.60);
        }

        p {
            display: flex;
            color: red;
            justify-content: center;
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
            margin-left: 15px;
            display: flex;
            justify-content: center;
            width: 237px;
        }
    </style>
</form>
</body>
</html>