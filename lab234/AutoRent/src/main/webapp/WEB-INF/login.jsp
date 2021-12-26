<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<jsp:include page="navbar.jsp" />

<div class="container">
    <form style="margin-top: 20px;" action="/login" method="POST" class="form-signin">

        <div class="form-group">
            <div class="col-sm-9">
                <input type="text" id="user_name" name="userName" placeholder="username"
                       class="form-control"/>
            </div>
        </div>
        <c:if test="${requestScope.wrongUserName != null}">
            <p>${requestScope.wrongUserName}</p>
        </c:if>

        <div class="form-group">
            <div class="col-sm-9">
                <input type="password" placeholder="password"
                       id="password" name="password" class="form-control"/>
            </div>
        </div>
        <c:if test="${requestScope.wrongPassword != null}">
            <p>${requestScope.wrongPassword}</p>
        </c:if>

        <c:if test="${requestScope.userBanned != null}">
            <p>${requestScope.userBanned}</p>
        </c:if>
        <button style="width: 200px; margin-top: 10px" class="btn btn-md btn-primary btn-block"
                name="Submit" value="Login" type="Submit">Login</button>
    </form>
    <form action="/registration" method="get">
        <button style="margin-top: 10px; width: 200px" class="btn btn-md btn-warning btn-block"
                type="Submit">Sign up</button>
    </form>

</div>
</body>
</html>
