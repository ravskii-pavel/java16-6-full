package ua.dp.levelup.DAO.impl;

import ua.dp.levelup.DAO.UserDAO;
import ua.dp.levelup.User;

import java.util.*;

/**
 * Created by java on 20.06.2017.
 */
public class UserDAOImpl implements UserDAO {
    private Map<Long, User> userByIdMap = new HashMap<>();
    private Map<String, Long> idByEMailMap = new HashMap<>();

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        Long userId = idByEMailMap.get(email);
        return userByIdMap.get(userId);
    }
    public void init(){
        List<User> users = Arrays.asList(
                new User(1L, "user1@gmail.com", "John", "Doe"),
                new User(2L, "user2@gmail.com", "Bob", "Doe"),
                new User(3L, "user3@gmail.com", "Tom", "Doe"),
                new User(4L, "user4@gmail.com", "Harry", "Doe"),
                new User(5L, "user5@gmail.com", "Sara", "Doe"),
                new User(6L, "user6@gmail.com", "Donald", "Trump")

        );

        Random random = new Random();
        for(User u : users){
            u.increaseBalance(random.nextInt(100) + 25);
            createUser(u);
        }
    }

    @Override
    public User getUserById(Long id) {
        return (User) idByEMailMap.values();
    }

    @Override
    public void createUser(User user) {

        userByIdMap.put(user.getId(), user);
        idByEMailMap.put(user.getEmail(), user.getId());
    }

    @Override
    public void deleteUser(User user) {
       userByIdMap.remove(user.getId());
       idByEMailMap.remove(user.getEmail());
    }

    @Override
    public void updateUser(User user) {
        userByIdMap.put(user.getId(), user);
        idByEMailMap.put(user.getEmail(), user.getId());
    }
}
