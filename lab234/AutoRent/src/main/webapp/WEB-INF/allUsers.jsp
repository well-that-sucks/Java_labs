<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>All users</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
<jsp:include page="navbar.jsp"/>

<div>
    <table id="example" class="table table-hover" style="text-align: center; align-content: center">
        <thead>
        <th>#</th>
        <th>Name</th>
        <th>Last name</th>
        <th>Username</th>
        <th>Email</th>
        <th>Active</th>
        <th>Role</th>
        <th>Ban action</th>
        <th>Set role</th>
        </thead>

        <tbody>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.email}</td>
                <td>${user.active == true ? 'Active' : 'Banned'}</td>
                <td>${user.role.name()}</td>
                <td><a href="${pageContext.request.contextPath}/banHandler?userId=${user.id}"
                       class="btn btn-primary ${user.role.name() == 'ADMIN' ? 'disabled' : 'active'}"
                    >${user.active == true ? 'Ban' : 'Unban'}</a></td>
                <td><a href="${pageContext.request.contextPath}/managerHandler?userId=${user.id}"
                       class="btn btn-danger ${user.role.name() == 'ADMIN' ? 'disabled' : 'active'}"
                    >${user.role.name() == 'USER' ? 'Upgrade' : 'Downgrade'}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
