<%--
  Created by IntelliJ IDEA.
  User: Peachex
  Date: 12/23/2020
  Time: 4:31 PM
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
    <title>Welcome</title>
</head>
<body>
<h2><fmt:message key="main.welcome"/></h2>
<hr style="color:#0d6efd;;" size="5"/>
<p>${user}, <fmt:message key="main.welcomeUser"/>!</p>
<hr style="color:#0d6efd;;" size="5"/>
<img src="${pageContext.request.contextPath}/image/tree.jpg" width="500" height="325" title="Happy New Year!">
<form name="logout" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
    <div class="d-grid gap-2 col-6 mx-auto">
        <button class="btn btn-primary button" type="submit"><fmt:message key="button.logout"/></button>
    </div>
</form>
<style>
    body {
        background-color: rgba(255, 255, 255, 0.60);
    }

    p {
        margin-block: 80px;
        font-size: 40px;
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

    img {
        margin-left: 710px;
        margin-bottom: -69px;
        margin-top: 29px;
        opacity: 0.9;
    }

    body {

    }
</style>
</body>
</html>
