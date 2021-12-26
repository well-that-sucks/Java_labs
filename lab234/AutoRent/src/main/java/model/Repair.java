package model;

import java.util.Objects;

public class Repair {
    private long id;
    private Order order;
    private long price;
    private Status payStatus;


    public Repair(long id, Order order, long price, Status payStatus) {
        this.id = id;
        this.order = order;
        this.price = price;
        this.payStatus = payStatus;
    }

    public Repair() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Status getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Status payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
        }
        if (o == null || getClass() != o.getClass()) {
        	return false;
        }
        Repair repair = (Repair)o;
        return id == repair.id && price == repair.price && Objects.equals(order, repair.order) && payStatus == repair.payStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, price, payStatus);
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", order=" + order +
                ", price=" + price +
                ", payStatus=" + payStatus +
                '}';
    }
}
