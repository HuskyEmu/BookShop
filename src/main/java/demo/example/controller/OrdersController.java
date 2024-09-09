package demo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.example.model.Orders;
import demo.example.service.OrdersService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    
    @GetMapping
	public ResponseEntity<List<Orders>> getAllOrders() {
		List<Orders> orders = ordersService.showAll();
		return ResponseEntity.ok(orders);
	}
    
    @PostMapping
    public ResponseEntity<List<Orders>> createOrders(@RequestBody List<Orders> orders) {
    	
        List<Orders> savedOrders = ordersService.saveAll(orders);
        return ResponseEntity.ok(savedOrders);
    }

}
