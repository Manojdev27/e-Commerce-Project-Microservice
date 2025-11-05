package com.hogwarts.orderservice.service;

import java.util.List;
import java.util.Optional;

import com.hogwarts.orderservice.dto.BulkOrderRequestDto;
import com.hogwarts.orderservice.dto.OrderRequestDto;
import com.hogwarts.orderservice.entity.Order;

public interface OrderService {

	public Order placeNewOrder(OrderRequestDto order);
	public List<Order> placeBulkOrder(BulkOrderRequestDto bulkOrderRequestDto);
	public List<Order> getAllOrders();
	public Optional<Order> getOrderById(Long id);
}
