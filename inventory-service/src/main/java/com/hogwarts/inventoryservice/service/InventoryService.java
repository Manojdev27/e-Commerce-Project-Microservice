package com.hogwarts.inventoryservice.service;

import java.util.List;

import com.hogwarts.inventoryservice.entity.Inventory;

public interface InventoryService {
	
	public Inventory updateInventory(Inventory inventory);
	public Inventory getInventoryByProductId(Long productId);
	public List<Inventory> getAllInventory();
//	public Inventory inventoryPut(int id, Inventory inventory);
}
