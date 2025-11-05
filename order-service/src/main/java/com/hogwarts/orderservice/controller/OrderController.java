package com.hogwarts.orderservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hogwarts.orderservice.dto.OrderRequestDto;
import com.hogwarts.orderservice.entity.Order;
import com.hogwarts.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/newOrder")
	public Order placeNewOrder(@RequestBody OrderRequestDto orderRequestDto)
	{
		return orderService.placeNewOrder(orderRequestDto);
	}
	
	@GetMapping("/allOrder")
	public List<Order> getAllOrders()
	{
		return orderService.getAllOrders();
	}
	
	@GetMapping("/{id}")
	public Optional<Order> getOrderById(@PathVariable Long id){
		
		return orderService.getOrderById(id);
		
	}

}
