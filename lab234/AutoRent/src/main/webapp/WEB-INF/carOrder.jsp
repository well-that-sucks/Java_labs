<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Order</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../static/css/style.css">

</head>

<body>
<jsp:include page="navbar.jsp" />

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form autocomplete="off" action="/carOrder?carId=${requestScope.carId}"
                  method="post" class="form-horizontal" role="form">
                <label for="userName">Ordered by:</label>
                <input type="text" class="form-control" id="userName"
                       value="${sessionScope.user.userName}" readonly>

                <label for="carName">Ordered car:</label>
                <input type="text" class="form-control" id="carName"
                       value="${requestScope.carToOrder.carName}" readonly>

                <label for="carPrice">Car price per hour:</label>
                <input type="text" class="form-control" id="carPrice"
                       value="${requestScope.carToOrder.carPrice}" readonly>

                <div class="form-group">
                    <div class="col-sm-12">
                        <label class="validation-message">Passport</label>
                        <input minlength="8" maxlength="9"
                               class="form-control" name="passport" required/>
                    </div>
                </div>

                <label for="driverPrice">Driver price per hour:</label>
                <input type="text" class="form-control" id="driverPrice" value="30" readonly>

                <div class="form-group">
                    <div class="col-sm-12">
                        <div class="form-check">
                            <label class="form-check-label" for="driver">With driver:</label>
                            <input class="form-check-input"
                                   type="checkbox" id="driver"
                                   name="withDriver">
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-12">
                        <label class="validation-message" for="startdatetime">Start date:</label>
                        <input name="startTime"
                               onclick="calcMinStartTime()"
                               onchange="getStartTime()"
                               id="startdatetime" type="datetime-local"
                               class="form-control" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-12">
                        <label class="validation-message" for="enddatetime" >End time</label>
                        <input name="endTime"
                               onclick="calcMinEndTime()"
                               onchange="getEndTime()"
                               id="enddatetime" type="datetime-local"  class="form-control" required>
                    </div>
                </div>

                <c:if test="${sessionScope.dateNotAvailableMessage != null}">
                    <span style="font-size: 12px; color: #FF1C19;"
                          class="validation-message">${sessionScope.dateNotAvailableMessage}</span>
                </c:if>

                <div class="form-group">
                    <div class="col-sm-12">
                        <label for="orderprice" >Price:</label>
                        <input name="orderPrice"
                               id="orderprice" type="text"  class="form-control" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary btn-block">Order car</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>



<script>
    let startDateInput = document.getElementById('startdatetime');
    let endDateInput = document.getElementById('enddatetime');
    let driverCheckbox = document.getElementById('driver');

    startDateInput.addEventListener("change", calcPrice)
    endDateInput.addEventListener("change", calcPrice)
    driverCheckbox.addEventListener("change", calcPrice)

    function getStartTime() {
        let startTime = startDateInput.value;
        let startTimeDate = new Date(startTime).getTime();
        return startTimeDate;
    }


    function getEndTime() {
        let endTime = endDateInput.value;
        let endTimeDate = new Date(endTime).getTime();
        return endTimeDate;
    }

    function calcPrice() {
        if (startDateInput.value !== '' &&
            endDateInput.value !== '') {
            const milliseconds = Math.abs(getEndTime() - getStartTime());
            const hours = Math.ceil(milliseconds / 36e5);

            let carPrice = document.getElementById('carPrice').value;
            let driverPrice = document.getElementById('driverPrice').value;
            let withDriver = document.getElementById('driver').checked;

            let orderPrice = hours*carPrice + hours * (withDriver ? driverPrice : 0);
            document.getElementById('orderprice').value = orderPrice;

        } else {
            document.getElementById('orderprice').value = 'Input start and date time';
        }

    }

    function calcMinStartTime() {
        let now = Date.now();
        let minStartDate = new Date(new Date(now)
            .toString().split('GMT')[0]+' UTC')
            .toISOString().split('.')[0]
            .slice(0, -3);
        document.getElementById('startdatetime').setAttribute("min", minStartDate);

        return minStartDate;
    }
    function calcMinEndTime() {
        let startDate = new Date(getStartTime());

        startDate.setHours(startDate.getHours() + 1);
        let minEndDate = new Date(new Date(startDate)
            .toString().split('GMT')[0]+' UTC')
            .toISOString().split('.')[0]
            .slice(0, -3);
        console.log('minEndDate: '+ minEndDate);
        document.getElementById('enddatetime').setAttribute("min", minEndDate);
        return startDate;
    }
</script>
</body>
</html>
