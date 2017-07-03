package service.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import core.model.User;
import dao.UserDao;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService, InitializingBean, DisposableBean {

    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("UserService constructor called");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("UserService afterPropertiesSet method called");
    }

    public void destroy() throws Exception {
        System.out.println("UserService destroy method called");
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

}
