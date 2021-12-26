<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><html>
<head>
  <title>All orders</title>
  <meta charset="ISO-8859-1" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link rel="stylesheet" href="../static/css/style.css">
</head>

<body>
<jsp:include page="navbar.jsp"/>

<table style="text-align: center; align-content: center" class="table table-hover">
  <thead>
<c:if test="${sessionScope.userRole == 'MANAGER'}">
    <th>#</th>
  </c:if>
  <th>Car name</th>
  <th>Car status</th>
  <th>Price</th>
  <th>Start date</th>
  <th>End date</th>
  <th>Status</th>
  <th>Pay status</th>
  <th>Ordered by</th>
  <th>Order rejection</th>

  <c:if test="${sessionScope.userRole == 'MANAGER'}">
    <th>Cancel order</th>
  </c:if>
  <c:if test="${sessionScope.userRole == 'USER'}">
    <th>Pay for order</th>
    <th>Pay for repair</th>
  </c:if>

  <c:if test="${sessionScope.userRole == 'MANAGER'}">
    <th>Accept order</th>
    <th>Reject order</th>
    <th>Register car repair</th>
    <th>Register car return</th>
  </c:if>
  </thead>
  <tbody>

    <c:forEach var="order" items="${requestScope.orders}">
      <c:if test="${order.user.id == sessionScope.user.id or sessionScope.userRole=='MANAGER'}">


      <tr>
        <c:if test="${sessionScope.userRole == 'MANAGER'}">
        <td>${order.car.id}</td>
        </c:if>
        <td>${order.car.carName}</td>
        <td>${order.car.status}</td>
        <td>${order.orderPrice}</td>
        <td>${order.startTime}</td>
        <td>${order.endTime}</td>
        <td>${order.status}</td>
        <td>${order.payStatus}</td>
        <td>${order.user.userName}</td>
          <td>${order.description}</td>
        <c:if test="${sessionScope.userRole == 'MANAGER'}">
          <td><a class="btn btn-danger">Cancel</a></td>
        </c:if>

        <c:if test="${sessionScope.userRole == 'USER'}">
          <td><a class="btn btn-primary">Pay for order</a></td>
        </c:if>
        <c:if test="${sessionScope.userRole == 'USER'}">
          <td><a class="btn btn-primary">Pay for repair</a></td>
        </c:if>

        <c:if test="${sessionScope.userRole == 'MANAGER'}">
          <th><a class="btn btn-primary">Accept order</a></th>
          <th><a class="btn btn-primary">Reject order</a></th>
          <th><a class="btn btn-primary">Register car repair</a></th>
          <th><a class="btn btn-primary">Register car return</a></th>
        </c:if>
      </tr>
      </c:if>
    </c:forEach>

  </tbody>
</table>
</body>
</html>
