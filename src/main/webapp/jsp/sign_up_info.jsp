<%--
  Created by IntelliJ IDEA.
  User: Peachex
  Date: 12/23/2020
  Time: 9:16 PM
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
    <title>Sign up</title>
</head>
<body>
<h2><fmt:message key="sign_up.pageTitle"/></h2>
<hr style="color:#0d6efd;;" size="5"/>
<p>${info}</p>
<hr style="color:#0d6efd;;" size="5"/>
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="redirect_to_sign_in">
    <div class="d-grid gap-2 col-6 mx-auto">
        <button class="btn btn-primary button" type="submit"><fmt:message key="button.back"/></button>
    </div>
</form>
<style>
    body {
        background-color: rgba(255, 255, 255, 0.60);
    }

    p {
        margin-block: 80px;
        font-size: 25px;
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
