package demo.example.service;

import java.util.List;

import demo.example.model.Orders;

public interface OrdersService {
    List<Orders> showAll();
    Orders createOrders(Orders orders);
    List<Orders> saveAll(List<Orders> orders); // New method for saving multiple orders
    void deleteOrders(Integer orderId);
}
