package service;

import dao.UserDao;
import dao.impl.DaoFactory;
import model.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserDao dao = DaoFactory.getUserDao();

    public Optional<User> findUserById(long id) {
        return dao.findUserById(id);
    }

    public List<User> findAllUsers() {
        return dao.findAll();
    }

    public Optional<User> findByUserName(String userName){
        return dao.findByUserName(userName);
    }

    public boolean createUser(User user) {
        return dao.addUser(user);
    }

    public boolean checkPasswordMatching(String password, User user) {
        return dao.checkPasswordMatching(password, user);
    }

    public boolean banHandler(long id) {
        return dao.banHandler(id);
    }

    public boolean managerRoleHandler(long id) {
        return dao.managerHandler(id);
    }
}
