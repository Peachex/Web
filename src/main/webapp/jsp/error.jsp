<%--
  Created by IntelliJ IDEA.
  User: Peachex
  Date: 12/23/2020
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <title>Error Page</title></head>
<body>
<div class="container">
    <div class="mb-5 row"></div>
    <div class = "col-12 header">
        Something Wrong
    </div>
    <div class="mb-5 row"></div>
    <div class="row">
        <div class="col-8 offset-2 text">
            Request from ${pageContext.errorData.requestURI} is failed
        </div>
    </div>
    <div class="row">
        <div class="col-8 offset-2 text">
            Servlet name or type: ${pageContext.errorData.servletName}
        </div>
    </div>
    <div class="row">
        <div class="col-8 offset-2 text">
            Status code: ${pageContext.errorData.statusCode}
        </div>
    </div>
    <div class="mb-5 row">
        <div class="col-8 offset-2 text">
            Exception: ${pageContext.errorData.throwable}
        </div>
    </div>
    <div class="row">
        <div class="col-4 offset-5">
            <form name="signIn" method="POST" action="controller">
                <input type="hidden" name="command" value="redirect_to_sign_in"/>
                <button class="btn btn-primary button" type="submit">Back</button>
            </form>
        </div>
    </div>
</div>
</div>
<style>
    body {
        background-color: rgba(255, 255, 255, 0.60);
    }

    .header {
        font-size: 50px;
        color: darkgrey;
        display: flex;
        justify-content: center;
    }

    .text {
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
