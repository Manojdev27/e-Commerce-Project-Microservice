package com.hogwarts.orderservice.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hogwarts.orderservice.client.InventoryClient;
import com.hogwarts.orderservice.dto.InventoryDTO;
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
	public Order placeNewOrder(Order order) {
		 InventoryDTO inventoryDTO = inventoryClient.getInventoryByProductId(order.getProductId());

		    if(inventoryDTO == null) {
		        throw new RuntimeException("The product is not found");
		    }

		    if(order.getQuantity() > inventoryDTO.getQuantity()) {
		        throw new RuntimeException("The order quantity is higher than the inventory quantity");
		    }

		    // Deduct order quantity from inventory quantity
		    int remainingQuantity = inventoryDTO.getQuantity() - order.getQuantity();
		    inventoryDTO.setQuantity(remainingQuantity);

		    inventoryClient.updateInventory(inventoryDTO);

		    order.setProductName(inventoryDTO.getProductName());

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
