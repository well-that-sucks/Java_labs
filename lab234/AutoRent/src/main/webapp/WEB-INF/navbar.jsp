<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
  <title>Navbar</title>
  <meta charset="ISO-8859-1" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/home">AutoRent</a>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <c:if test="${sessionScope.user != null}">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page"
                 href="${pageContext.request.contextPath}/carPage">Car page</a>
            </li>
          </c:if>

          <c:if test="${sessionScope.userRole == 'ADMIN'}">
            <li class="nav-item">
              <a class="nav-link"
                 href="${pageContext.request.contextPath}/carAdd">Add car</a>
            </li>
          </c:if>


          <c:if test="${sessionScope.userRole == 'ADMIN'}">
            <li class="nav-item">
              <a class="nav-link"
                 href="${pageContext.request.contextPath}/allUsers">All users</a>
            </li>
          </c:if>

          <c:if test="${sessionScope.userRole == 'USER' or sessionScope.userRole == 'MANAGER'}">
            <li class="nav-item">
              <a class="nav-link"
                 href="${pageContext.request.contextPath}/allOrders">All orders</a>
            </li>
          </c:if>

        </ul>

        <c:if test="${sessionScope.user != null}">
          <form action="/logout" method="get"  class="d-flex">
            <button type="submit" class="btn btn-outline-danger">Logout</button>
          </form>
        </c:if>

      </div>
    </div>
  </nav>
</div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
