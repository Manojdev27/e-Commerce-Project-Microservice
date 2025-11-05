package com.hogwarts.orderservice.dto;

import lombok.Data;

@Data
public class OrderRequestDto {
	private Long productId;
	private int quantity;
}
