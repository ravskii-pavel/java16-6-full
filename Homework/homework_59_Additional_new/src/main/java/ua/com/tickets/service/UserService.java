package ua.com.tickets.service;

import ua.com.tickets.core.model.User;

import java.util.List;

/**
 * Created by java on 16.06.2017.
 */
public interface UserService {

    List<User> getAllUsers();
    User getUserByEmail(String email);
    User getUserById(Long id);
    void createUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
