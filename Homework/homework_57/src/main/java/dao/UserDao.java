package dao;

import core.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    User getUserByEmail(String email);
    User getUserById(Long id);
    void createUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
