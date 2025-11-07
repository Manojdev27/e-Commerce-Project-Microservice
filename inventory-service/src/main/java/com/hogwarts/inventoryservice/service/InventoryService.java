package com.hogwarts.inventoryservice.service;

import java.util.List;
import java.util.Optional;

import com.hogwarts.inventoryservice.entity.Inventory;
import com.hogwarts.inventoryservice.entity.dto.InventoryDto;

public interface InventoryService {
	
	public Inventory updateInventory(InventoryDto inventory);
	public Optional<Inventory> getInventoryByProductId(Long productId);
	public List<Inventory> getAllInventory();
	public Inventory inventoryPut(Long id, InventoryDto inventoryDto);
}
