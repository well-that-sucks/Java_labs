package utils;

public class DBQueries {

    public static final String ADD_USER = "insert into users" +
            "(active, email, last_name, name, password, user_name, role) " +
            "values (?,?,?,?,?,?,?)";
    public static final String FIND_USER_BY_ID = "select * from users where user_id = ?";
    public static final String FIND_ALL_USERS = "select * from users";
    public static final String FIND_USER_BY_USERNAME = "select * from users where user_name = ?";
    public static final String SET_MANAGER_OR_USER_ROLE = "update users set role=? where user_id=?";
    public static final String SET_BAN_OR_UNBAN = "update users set active=? where user_id=?";

    public static final String ADD_CAR = "insert into cars(mark, name, price, quality, status) values (?,?,?,?,?)";
    public static final String FIND_CAR_BY_ID = "select * from cars where car_id = ?";
    public static final String FIND_CARS_BY_MARK = "select * from cars where mark = ?";
    public static final String FIND_CARS_BY_QUALITY = "select * from cars where quality = ?";
    public static final String DELETE_CAR_BY_ID = "delete from cars where car_id = ?";
    public static final String FIND_ALL_CARS = "select * from cars";
    public static final String UPDATE_CAR_BY_ID = "update cars set mark=?, name=?, price=?, quality=?, status=?" +
            " where car_id=?";

    public static final String ADD_ORDER = "insert into orders" +
        "(description, start_time, end_time, price, user_passport, " +
        "pay_status, status, with_driver, car_id, user_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String FIND_ORDER_BY_ID = "select * from orders where order_id = ?";
    public static final String FIND_ALL_ORDERS = "select * from orders";
    public static final String FIND_ORDERS_BY_CAR_ID = "select * from orders where car_id = ?";
    public static final String DELETE_ORDER_BY_ID = "delete from orders where order_id = ?";

    public static final String FIND_REPAIR_BY_ID = "select * from repairs where id = ?";
    public static final String FIND_ALL_REPAIRS = "select * from repairs";
    public static final String FIND_REPAIR_BY_ORDER_ID = "select * from repairs where order_id = ?";

}
