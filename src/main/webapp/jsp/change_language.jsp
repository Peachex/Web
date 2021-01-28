<%--
  Created by IntelliJ IDEA.
  User: Peachex
  Date: 1/23/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${currentLocale}"/>
<fmt:setBundle basename="locale.page_content"/>
<html>
<head>
    <title>Change language</title>
</head>
<body>
<div class="container">
    <div class="mb-3 row">
        <div class="col-4 offset-5">
            <form name="UsersInfoForm" method="POST" action="controller">
                <input type="hidden" name="command" value="change_language"/>
                <button class="btn btn-primary button" type="submit"><fmt:message key="button.changeLanguage"/></button>
            </form>
        </div>
    </div>
</div>
<style>
    body {
        background-color: rgba(255, 255, 255, 0.60);
    }

    .button {
        display: flex;
        justify-content: center;
        width: 100%;
    }
</style>
</body>
</html>
