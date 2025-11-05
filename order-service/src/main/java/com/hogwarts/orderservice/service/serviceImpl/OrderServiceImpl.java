package com.hogwarts.orderservice.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hogwarts.orderservice.client.InventoryClient;
import com.hogwarts.orderservice.dto.InventoryDTO;
import com.hogwarts.orderservice.dto.OrderRequestDto;
import com.hogwarts.orderservice.entity.Order;
import com.hogwarts.orderservice.repository.OrderRepository;
import com.hogwarts.orderservice.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private InventoryClient inventoryClient;

	@Override
	public Order placeNewOrder(OrderRequestDto orderRequestDto) {
	    InventoryDTO inventoryDTO = inventoryClient.getInventoryByProductId(orderRequestDto.getProductId());

	    if (inventoryDTO == null) {
	        throw new RuntimeException("Product not found in inventory");
	    }

	    if (orderRequestDto.getQuantity() > inventoryDTO.getQuantity()) {
	        throw new RuntimeException("Order quantity exceeds available inventory");
	    }

	    // Deduct quantity from inventory
	    int remainingQuantity = inventoryDTO.getQuantity() - orderRequestDto.getQuantity();
	    inventoryDTO.setQuantity(remainingQuantity);
	    inventoryClient.updateInventory(inventoryDTO);

	    // Map OrderRequestDto to Order entity
	    Order order = new Order();
	    order.setProductId(orderRequestDto.getProductId());
	    order.setQuantity(orderRequestDto.getQuantity());
	    order.setProductName(inventoryDTO.getProductName());

	    // Save and return the order
	    return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

}
