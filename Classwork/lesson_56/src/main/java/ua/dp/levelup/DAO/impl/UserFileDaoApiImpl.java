package ua.dp.levelup.DAO.impl;

import ua.dp.levelup.DAO.UserDAO;
import ua.dp.levelup.User;

import java.io.File;
import java.util.List;

/**
 * Created by java on 20.06.2017.
 */
public class UserFileDaoApiImpl implements UserDAO {

    private final String filePath;

    public UserFileDaoApiImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<User> getAllUsers() {
        File file = new File(filePath);

        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }
}
