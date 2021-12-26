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


