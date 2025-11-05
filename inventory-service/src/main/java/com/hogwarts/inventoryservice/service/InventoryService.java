package com.hogwarts.inventoryservice.service;

import java.util.List;

import com.hogwarts.inventoryservice.entity.Inventory;
import com.hogwarts.inventoryservice.entity.dto.InventoryDto;

public interface InventoryService {
	
	public Inventory updateInventory(InventoryDto inventory);
	public Inventory getInventoryByProductId(Long productId);
	public List<Inventory> getAllInventory();
//	public Inventory inventoryPut(int id, Inventory inventory);
}
