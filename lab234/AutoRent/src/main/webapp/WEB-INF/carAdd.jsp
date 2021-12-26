<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><html>
<head>
    <title>Car add</title>
    <meta charset="ISO-8859-1" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../static/css/style.css">
</head>

<body>
<jsp:include page="navbar.jsp"/>

<div>
  <form autocomplete="off" action="/carAdd" method="post" class="form-horizontal" role="form">
    <div class="form-group">
      <div class="col-sm-9">

        <div class="form-group">
          <div class="col-sm-9">
            <input type="text" placeholder="Name" name="carName"
                   class="form-control" minlength="1" maxlength="30"/>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-9">
            <input type="text" placeholder="Mark" name="carMark"
                   class="form-control" minlength="1" maxlength="30"/>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-9">
            <input type="text" placeholder="Quality" name="carQuality"
                   class="form-control" minlength="1" maxlength="1"/>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-9">
            <input type="number" placeholder="Price per hour" name="carPrice"
                   class="form-control" minlength="1"/>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-9">
            <button type="submit" class="btn btn-primary btn-block">Add car</button>
          </div>
        </div>

          <c:if test="${sessionScope.successMessage != null}">
              <h2 ><span class="text-success">${sessionScope.successMessage}</span></h2>
          </c:if>
      </div>
    </div>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
