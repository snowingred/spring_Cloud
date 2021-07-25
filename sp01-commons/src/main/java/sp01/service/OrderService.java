package sp01.service;

import sp01.pojo.Order;

public interface OrderService {
    Order getOrder(String orderId);
    void addOrder(Order order);
}