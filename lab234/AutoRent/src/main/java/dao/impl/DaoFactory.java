package dao.impl;

import dao.CarDao;
import dao.OrderDao;
import dao.UserDao;
import utils.DBUtil;

import java.sql.Connection;

public class DaoFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl(DBUtil.getConnection());
    }

    public static CarDao getCarDao() {
        return new CarDaoImpl(DBUtil.getConnection());
    }

    public static OrderDao getOrderDao() {
        return new OrderDaoImpl(DBUtil.getConnection());
    }
}
