package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static Connection conn = null;
    public static Connection getConnection() {
        if(conn != null) {
            return conn;
        } else {
            try
            {
                String url = "jdbc:postgresql://localhost:5432/AutoRent";
                String driver = "org.postgresql.Driver";
                String username = "postgres";
                String password = "123456";
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

    }
}
