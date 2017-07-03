package ua.dp.levelup.service.impl;

import ua.dp.levelup.dao.OrderDao;
import ua.dp.levelup.service.OrderService;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public class OrderServiceImpl implements OrderService {

  private OrderDao orderDao;

  public void setOrderDao(final OrderDao orderDao) {
    this.orderDao = orderDao;
  }
}
