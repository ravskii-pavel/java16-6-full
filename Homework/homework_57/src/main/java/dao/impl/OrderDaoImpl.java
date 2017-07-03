package dao.impl;

import core.model.Order;
import core.model.Ticket;
import core.model.User;
import dao.OrderDao;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class OrderDaoImpl implements OrderDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

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
