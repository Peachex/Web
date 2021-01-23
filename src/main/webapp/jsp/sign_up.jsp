<%--
  Created by IntelliJ IDEA.
  User: Peachex
  Date: 12/25/2020
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${currentLocale}"/>
<fmt:setBundle basename="locale.page_content"/>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <title>Sign Up</title>
</head>
<body>

<h2><fmt:message key="sign_up.pageTitle"/></h2>
<hr style="color:#0d6efd;;" size="5"/>
<div class="container">
    <form name="signUpForm" method="POST" action="controller">
        <input type="hidden" name="command" value="sign_up"/>
        <div class="mb-3 row">
            <label for="inputLogin" style="text-align: center;" class="col-2 offset-5 col-form-label"><fmt:message
                    key="sign_in.loginMessage"/></label>
        </div>
        <div class="mb-3 row">
            <div class="offset-4 col-4">
                <input type="text" class="form-control field" id="inputLogin" name="login"
                       placeholder="Must have at least 2 characters" required
                       pattern="^[A-Za-zА-яа-я0-9_]{2,20}$">
            </div>
           <fmt:message key="sign_up.properLoginFormat"/>
        </div>
        <div class="mb-3 row">
            <wrongMessage>
                ${errorLoginName}
            </wrongMessage>
        </div>
        <div class="mb-3 row">
            <label for="inputPassword" style="text-align: center;"
                   class="col-2 offset-5 col-form-label"><fmt:message
                    key="sign_in.passwordMessage"/></label>
        </div>
        <div class="mb-3 row">
            <div class="col-4 offset-4">
                <input type="password" class="form-control field" id="inputPassword" name="password2"
                       placeholder="Must have at least 4 characters" required
                       pattern="^[A-Za-z0-9_]{4,20}$">
            </div>
            <fmt:message key="sign_up.properPasswordFormat"/>
        </div>
        <div class="mb-3 row">
            <div class="col-4 offset-4">
                <label for="inputPassword" style="text-align: center; display: flex; justify-content: center"
                       class="col-2 offset-5 col-form-label"><fmt:message
                        key="sign_up.repeatPasswordMessage"/> </label>
            </div>
        </div>
        <div class="mb-3 row">
            <div class="col-4 offset-4">
                <input type="password" class="form-control field" id="repeatPassword" name="rePassword"
                       required
                       pattern="^[A-Za-z0-9_]{4,20}$">
            </div>
        </div>
        <div class="mb-3 row">
            <wrongMessage>
                ${errorPasswordRepeat}
            </wrongMessage>
        </div>
        <div class="mb-3 row">
            <div class="col-4 offset-5">
                <button class="btn btn-primary button" type="submit"><fmt:message key="button.sign_up"/></button>
            </div>
        </div>
    </form>
    <div class="mb-3 row">
        <div class="col-4 offset-5">
            <form name="SignIp" method="POST" action="controller">
                <input type="hidden" name="command" value="redirect_to_sign_in"/>
                <button class="btn btn-primary button" type="submit"><fmt:message key="button.back"/></button>
            </form>
        </div>
    </div>
    <c:import url="change_language.jsp"/>
</div>
<style>
    body {
        background-color: rgba(255, 255, 255, 0.60);
    }

    wrongMessage {
        display: flex;
        color: red;
        justify-content: center;
    }

    h2 {
        display: flex;
        margin-top: 15px;
        justify-content: center;
    }

    .button {
        width: 50%;
    }
</style>
</body>
</html>
