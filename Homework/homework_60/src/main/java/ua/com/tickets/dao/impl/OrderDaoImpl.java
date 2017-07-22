package ua.com.tickets.dao.impl;

import ua.com.tickets.core.model.Order;
import ua.com.tickets.core.model.Ticket;
import ua.com.tickets.core.model.User;
import ua.com.tickets.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void createOrder(Order order) { hibernateTemplate.save(order); }

    @Override
    public List<Order> getAllOrders() {
        List<Order> listOrders = hibernateTemplate.loadAll(Order.class);
        if(null != listOrders) {
            for (Order o : listOrders) {
                List<Ticket> ticketList = o.getTicketList();
                ticketList.toString(); //Ели Fetch - Lazy, Чтобы не получать LazyInitializationException - не обязательно создавать новую сессию и открывать транзакцию. Достаточно сделать sout map или каждого объекта в цикле foreach, который лежит в map. (или FetchType = EGER)
                User user = o.getUser();
                user.toString();
            }
        }
        return listOrders;
    }

    @Override
    public Order getOrderById(Long id) {
        Order order = hibernateTemplate.load(Order.class, id);
        order.toString();
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        hibernateTemplate.update(order);
    }

    @Override
    public void deleteOrder(Order order) {
        hibernateTemplate.delete(order);
    }
}
