package com.hogwarts.inventoryservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hogwarts.inventoryservice.entity.Inventory;
import com.hogwarts.inventoryservice.entity.dto.InventoryDto;
import com.hogwarts.inventoryservice.service.InventoryService;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/inventoryUpdate")
	public Inventory updateInventory(@RequestBody InventoryDto inventory) {
		return inventoryService.updateInventory(inventory);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
	    Optional<Inventory> item = inventoryService.getInventoryByProductId(id);
	    return item.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/getAllInventory")
	public List<Inventory> getAllInventory(){
		return inventoryService.getAllInventory();
	}
	
	@PutMapping("/{productId}")
	public Inventory inventoryPut(@PathVariable Long productId, @RequestBody InventoryDto inventoryDto) {
		Inventory updatedInventory = inventoryService.inventoryPut(productId, inventoryDto);
		return updatedInventory;
		
	}
}
