<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Car add</title>
  <meta charset="ISO-8859-1" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
<jsp:include page="navbar.jsp" />

<div>
  <form autocomplete="off" action="/carUpdate?carId=${requestScope.carId}" method="post"
        class="form-horizontal"
        role="form">
    <div class="form-group">
      <div class="col-sm-9">

        <div class="form-group">
          <div class="col-sm-9">
            <input type="text" placeholder="Name" name="carName"
                   class="form-control" value="${requestScope.carToUpdate.carName}"
                   minlength="1" maxlength="30"/>
            <%--            <label class="validation-message"></label>--%>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-9">
            <input type="text" placeholder="Mark" name="carMark"
                   class="form-control" value="${requestScope.carToUpdate.carMark}"
                   minlength="1" maxlength="30"/>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-9">
            <input type="text" placeholder="Quality" name="carQuality"
                   class="form-control" value="${requestScope.carToUpdate.carQuality}"
                   minlength="1" maxlength="1"/>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-9">
            <input type="number" placeholder="Price per hour" name="carPrice"
                   class="form-control" value="${requestScope.carToUpdate.carPrice}"
                   minlength="1"/>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-9">

            <select class="form-select" name="carStatus">
              <option value="${requestScope.currentStatus}" selected>${requestScope.currentStatus}</option>
              <c:forEach items="${requestScope.allStatuses}" var="status">
                <c:if test="${status != requestScope.currentStatus}">
                  <option value="${status}">${status}</option>
                </c:if>
              </c:forEach>
            </select>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-9">
            <button type="submit" class="btn btn-primary btn-block">Update car</button>
          </div>
        </div>

      </div>
    </div>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
