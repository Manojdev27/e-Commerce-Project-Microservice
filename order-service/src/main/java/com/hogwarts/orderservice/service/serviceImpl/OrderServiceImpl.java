package com.hogwarts.orderservice.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hogwarts.orderservice.client.InventoryClient;
import com.hogwarts.orderservice.dto.BulkOrderRequestDto;
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

	@Override
	public List<Order> placeBulkOrder(BulkOrderRequestDto bulkOrderRequestDto) {
		List<Order> savedOrders = new ArrayList<>();

	    for (OrderRequestDto orderRequest : bulkOrderRequestDto.getOrders()) {
	        InventoryDTO inventoryDTO = inventoryClient.getInventoryByProductId(orderRequest.getProductId());
	        if (inventoryDTO == null) {
	            throw new RuntimeException("Product not found: " + orderRequest.getProductId());
	        }
	        if (orderRequest.getQuantity() > inventoryDTO.getQuantity()) {
	            throw new RuntimeException("Order quantity exceeds available inventory for product: " + orderRequest.getProductId());
	        }

	        // Deduct inventory quantity
	        int remainingQuantity = inventoryDTO.getQuantity() - orderRequest.getQuantity();
	        inventoryDTO.setQuantity(remainingQuantity);
	        inventoryClient.updateInventory(inventoryDTO);

	        // Create and save order
	        Order order = new Order();
	        order.setProductId(orderRequest.getProductId());
	        order.setQuantity(orderRequest.getQuantity());
	        order.setProductName(inventoryDTO.getProductName());

	        savedOrders.add(orderRepository.save(order));
	    }

	    return savedOrders;
	}

}
