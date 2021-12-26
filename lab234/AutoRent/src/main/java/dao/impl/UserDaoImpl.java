package dao.impl;

import model.Status;
import utils.BCrypt;
import dao.UserDao;
import dao.impl.extractUtil.UserExtract;
import model.Role;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static utils.DBQueries.*;

public class UserDaoImpl implements UserDao {

    private Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addUser(User entity) {
        try (PreparedStatement ps = connection.prepareStatement(ADD_USER)) {
            ps.setBoolean(1, true);
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getName());
            ps.setString(5, BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt(12)));
            ps.setString(6, entity.getUserName());
            ps.setString(7, String.valueOf(Role.USER));
            ps.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Optional<User> findUserById(long id) {
        Optional<User> user = Optional.ofNullable(null);
        try (PreparedStatement ps = connection.prepareStatement(FIND_USER_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = Optional.of(UserExtract.extractUser(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_USERS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(UserExtract.extractUser(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        Optional<User> user = Optional.ofNullable(null);
        try (PreparedStatement ps = connection.prepareStatement(FIND_USER_BY_USERNAME)) {
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = Optional.of(UserExtract.extractUser(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public boolean checkPasswordMatching(String passwordToCheck, User user) {
        return BCrypt.checkpw(passwordToCheck, user.getPassword());
    }

    @Override
    public boolean banHandler(long id) {
        try (PreparedStatement ps = connection.prepareStatement(SET_BAN_OR_UNBAN)) {
            User user = findUserById(id).orElseThrow(NoSuchElementException::new);
            if (user.getActive()) {
                ps.setBoolean(1, false);
            } else {
                ps.setBoolean(1, true);
            }
            ps.setLong(2, id);
            ps.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean managerHandler(long id) {
        try (PreparedStatement ps = connection.prepareStatement(SET_MANAGER_OR_USER_ROLE)) {
            User user = findUserById(id).orElseThrow(NoSuchElementException::new);
            if (user.getRole().equals(Role.USER)) {
                ps.setString(1, Role.MANAGER.name());
            } else {
                ps.setString(1, Role.USER.name());
            }
            ps.setLong(2, id);
            ps.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
