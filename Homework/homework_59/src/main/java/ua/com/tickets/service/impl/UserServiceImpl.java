package ua.com.tickets.service.impl;

import ua.com.tickets.core.model.User;
import ua.com.tickets.dao.UserDao;
import org.springframework.stereotype.Service;
import ua.com.tickets.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Resource(name = "userDao")
    public void setUserDao(UserDao userDao) { this.userDao = userDao; }

    public UserServiceImpl() {
        System.out.println("UserService constructor called");
    }

/*    public void afterPropertiesSet() throws Exception {
        System.out.println("UserService afterPropertiesSet method called");
    }

    public void destroy() throws Exception {
        System.out.println("UserService destroy method called");
    }*/

    public UserDao getUserDao() {
        return userDao;
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
