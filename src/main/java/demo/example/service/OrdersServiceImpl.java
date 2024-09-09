package demo.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.model.Orders;
import demo.example.model.OrdersRepository;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<Orders> showAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders createOrders(Orders orders) {
        return ordersRepository.save(orders);
    }


    @Override
    public void deleteOrders(Integer orderId) {
        ordersRepository.deleteById(orderId);
    }

	@Override
	 public List<Orders> saveAll(List<Orders> orders) {
        return ordersRepository.saveAll(orders);
    }

}