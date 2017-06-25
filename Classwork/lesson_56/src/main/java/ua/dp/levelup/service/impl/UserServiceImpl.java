package ua.dp.levelup.service.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import ua.dp.levelup.DAO.UserDAO;
import ua.dp.levelup.Profiling;
import ua.dp.levelup.User;
import ua.dp.levelup.service.UserService;

import java.util.List;

/**
 * Created by java on 16.06.2017.
 */
public class UserServiceImpl implements UserService, InitializingBean, DisposableBean {

    private UserDAO userDAO;

    public UserServiceImpl(){
        System.out.println("UserService constructor called: " + "Phase - 1");
        //System.out.println(this);
        //doMagic();
    }
//   @PostConstruct

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void init(){
        System.out.println("init started - call the INIT method when the bean is instantiated.: Phase - 2");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("UserService afterPropertiesSet method called");
        doMagic();
    }

    public void destroy() throws Exception {
        System.out.println("UserService destroy!");
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Profiling
    public void doMagic(){
        System.out.println("UserService does magic");
    }

}
