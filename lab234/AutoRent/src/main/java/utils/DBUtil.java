package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class DBUtil {
	static final Logger LOGGER = Logger.getLogger(DBUtil.class);
    private static Connection conn = null;
    public static Connection getConnection() {
        if(conn != null) {
            return conn;
        } else {
            try {
                String url = "jdbc:postgresql://localhost:5432/AutoRent";
                String driver = "org.postgresql.Driver";
                String username = "postgres";
                String password = "123456";
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
            	LOGGER.info("Failed to open a database connection");
                e.printStackTrace();
            }
            LOGGER.info("Successfully opened a database connection");
            return conn;
        }

    }
}
