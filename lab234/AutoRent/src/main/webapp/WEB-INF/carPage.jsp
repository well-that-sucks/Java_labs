<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Car page</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
<jsp:include page="navbar.jsp" />

<div>
  <table id="example" class="table table-hover" style="text-align: center; align-content: center">
    <thead>
        <c:if test="${sessionScope.userRole == 'ADMIN' or sessionScope.userRole == 'MANAGER'}">
        <th>#</th>
        </c:if>
        <th>Name</th>
        <th>Mark</th>
        <th>Quality</th>
        <th>Price</th>
        <th>Status</th>
        <c:if test="${sessionScope.userRole == 'ADMIN'}">
          <th>Update</th>
          <th>Delete</th>
        </c:if>
        <c:if test="${sessionScope.userRole == 'USER'}">
          <th>Order</th>
        </c:if>
    </thead>

    <tbody>
    <c:forEach var="car" items="${requestScope.cars}">
      <tr>
          <c:if test="${sessionScope.userRole == 'ADMIN' or sessionScope.userRole == 'MANAGER'}">
          <td>${car.id}</td>
          </c:if>
        <td>${car.carName}</td>
        <td>${car.carMark}</td>
        <td>${car.carQuality}</td>
        <td>${car.carPrice}</td>
        <td>${car.status}</td>
        <c:if test="${sessionScope.userRole == 'ADMIN'}">
          <td><a href="${pageContext.request.contextPath}/carUpdate?carId=${car.id}"
                 class="btn btn-primary">Update</a></td>
          <td><a href="${pageContext.request.contextPath}/carDelete?carId=${car.id}"
                 class="btn btn-danger">Delete</a></td>
        </c:if>
        <c:if test="${sessionScope.userRole == 'USER'}">
          <td><a href="${pageContext.request.contextPath}/carOrder?carId=${car.id}"
                 class="btn btn-primary ${car.status.name() == 'REPAIR' ? 'disabled' : 'active'}">Order</a></td>
        </c:if>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
