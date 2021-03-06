package dao.impl;

import core.model.Order;
import core.model.User;
import dao.UserDao;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
public class UserDaoImpl implements UserDao {

    private HibernateTemplate hibernateTemplate;
    private Map<Long, User> userByIdMap = new HashMap<>();
    private Map<String, Long> idByEmailMap = new HashMap<>();

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void init() {
        //User user = new User("Ravskiy Pavel", "ravskii.pavel@gmail.com", "0663599262");
    }

    @Override
    public List<User> getAllUsers() {

        List<User> listUsers = hibernateTemplate.loadAll(User.class);
        //List<User> listUsers1 = (List<User>) hibernateTemplate.find("select name from User where id = ?");
        //List<User> listUsers1 = hibernateTemplate.find("from" + User + "where");
        //List<User> listUsers = userQuery.list();
        for (User u : listUsers){
            //List<Order> orderList = u.getOrderList();
                //orderList.toString();
                userByIdMap.put(u.getId(), u);
                idByEmailMap.put(u.getEmail(), u.getId());
        }
        return listUsers;
    }

    @Override
    public User getUserByEmail(String email) {
        Long userId = idByEmailMap.get(email);
        return userByIdMap.get(userId);
    }

    @Override
    public User getUserById(Long id) {
        return userByIdMap.get(id);
    }

    @Override
    public void createUser(User user) {
        hibernateTemplate.save(user);
        userByIdMap.put(user.getId(), user);
        idByEmailMap.put(user.getEmail(), user.getId());
        //return user;
    }

    @Override
    public void deleteUser(User user) {
        userByIdMap.remove(user.getId());
        idByEmailMap.remove(user.getEmail());
        hibernateTemplate.delete(user);
    }

    @Override
    public void updateUser(User user) {
        userByIdMap.put(user.getId(), user);
        idByEmailMap.put(user.getEmail(), user.getId());
        hibernateTemplate.update(user);
    }
}
