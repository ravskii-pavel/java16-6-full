package ua.dp.levelup.service.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import ua.dp.levelup.Profiling;
import ua.dp.levelup.User;
import ua.dp.levelup.dao.UserDao;
import ua.dp.levelup.service.UserService;

import java.util.List;

/**
 * Created by java on 16.06.2017.
 */
public class UserServiceImpl implements UserService, InitializingBean, DisposableBean {

    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("UserService constructor called");
        doMagic();
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("UserService afterPropertiesSet method called");
        doMagic();
    }

    public void destroy() throws Exception {
        System.out.println("UserService destroy method called");
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

    @Profiling
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

    @Profiling
    public void doMagic() {
        System.out.println("UserService does magic");
    }
}
