package model;

import java.util.Objects;

public class Car {
    private long id;
    private String carName;
    private String carMark;
    private String carQuality;
    private long carPrice;
    private Status status;

    public Car(long id, String carName, String carMark, String carQuality, long carPrice, Status status) {
        this.id = id;
        this.carName = carName;
        this.carMark = carMark;
        this.carQuality = carQuality;
        this.carPrice = carPrice;
        this.status = status;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public String getCarQuality() {
        return carQuality;
    }

    public void setCarQuality(String carQuality) {
        this.carQuality = carQuality;
    }

    public long getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(long carPrice) {
        this.carPrice = carPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
        }
        if (o == null || getClass() != o.getClass()) {
        	return false;
        }
        Car car = (Car)o;
        return id == car.id && carPrice == car.carPrice && Objects.equals(carName, car.carName) && Objects.equals(carMark, car.carMark) && Objects.equals(carQuality, car.carQuality) && status == car.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carName, carMark, carQuality, carPrice, status);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carMark='" + carMark + '\'' +
                ", carQuality='" + carQuality + '\'' +
                ", carPrice=" + carPrice +
                ", status=" + status +
                '}';
    }
}
