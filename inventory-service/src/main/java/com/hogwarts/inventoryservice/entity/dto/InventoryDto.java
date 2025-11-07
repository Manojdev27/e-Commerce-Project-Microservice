package com.hogwarts.inventoryservice.entity.dto;

import lombok.Data;

@Data
public class InventoryDto {
	private Long productId;
	private int quantity;
}
