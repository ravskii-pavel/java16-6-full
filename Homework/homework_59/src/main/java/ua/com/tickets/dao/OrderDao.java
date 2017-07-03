package ua.com.tickets.dao;

import ua.com.tickets.core.model.Order;

import java.util.List;

public interface OrderDao {

    void createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    void updateOrder(Order order);
    void deleteOrder(Order order);
}
