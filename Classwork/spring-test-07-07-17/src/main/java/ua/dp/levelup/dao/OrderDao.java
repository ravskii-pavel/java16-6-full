package ua.dp.levelup.dao;

import ua.dp.levelup.core.model.Order;
import ua.dp.levelup.core.model.Ticket;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public interface OrderDao {
    void createOrder(Order order);

    void createOrder(Order order, Ticket ticket);

    Order getOrderById(long orderId);
}
