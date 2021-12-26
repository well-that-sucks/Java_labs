package service;

import dao.OrderDao;
import dao.impl.DaoFactory;
import model.Order;

import java.util.List;
import java.util.Optional;

public class OrderService {
    private OrderDao dao = DaoFactory.getOrderDao();

    public boolean addOrder(Order order, long carId, long userId) {
        return dao.addOrder(order, carId, userId);
    }

    public Optional<Order> findById(long id) {
        return dao.findById(id);
    }

    public List<Order> findAll() {
        return dao.findAll();
    }

    public List<Order> findAllByCarId(long id) {
        return dao.findAllByCarId(id);
    }

    public boolean deleteById(long id) {
        return dao.deleteById(id);
    }
}
