package dao.impl.extractUtil;

import model.Role;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExtract {
    public static User extractUser(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getLong("user_id"));
        user.setName(rs.getString("name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setUserName(rs.getString("user_name"));
        user.setPassword(rs.getString("password"));
        user.setActive(rs.getBoolean("active"));
        user.setRole(Role.valueOf(rs.getString("role")));

        return user;
    }
}
