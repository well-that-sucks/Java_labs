package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private long id;
    private Car car;
    private User user;
    private String passport;
    private Boolean withDriver;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long orderPrice;
    private Status status;
    private Status payStatus;
    private String description;

    public Order() { }

    public Order(long id, Car car, User user, String passport, Boolean withDriver, LocalDateTime startTime, LocalDateTime endTime, long orderPrice, Status status, Status payStatus, String description) {
        this.id = id;
        this.car = car;
        this.user = user;
        this.passport = passport;
        this.withDriver = withDriver;
        this.startTime = startTime;
        this.endTime = endTime;
        this.orderPrice = orderPrice;
        this.status = status;
        this.payStatus = payStatus;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Boolean getWithDriver() {
        return withDriver;
    }

    public void setWithDriver(Boolean withDriver) {
        this.withDriver = withDriver;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(long orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Status payStatus) {
        this.payStatus = payStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
        }
        if (o == null || getClass() != o.getClass()) {
        	return false;
        }
        Order order = (Order)o;
        return id == order.id && orderPrice == order.orderPrice && Objects.equals(car, order.car) && Objects.equals(user, order.user) && Objects.equals(passport, order.passport) && Objects.equals(withDriver, order.withDriver) && Objects.equals(startTime, order.startTime) && Objects.equals(endTime, order.endTime) && status == order.status && payStatus == order.payStatus && Objects.equals(description, order.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, user, passport, withDriver, startTime, endTime, orderPrice, status, payStatus, description);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", car=" + car +
                ", user=" + user +
                ", passport='" + passport + '\'' +
                ", withDriver=" + withDriver +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", orderPrice=" + orderPrice +
                ", status=" + status +
                ", payStatus=" + payStatus +
                ", description='" + description + '\'' +
                '}';
    }
}
