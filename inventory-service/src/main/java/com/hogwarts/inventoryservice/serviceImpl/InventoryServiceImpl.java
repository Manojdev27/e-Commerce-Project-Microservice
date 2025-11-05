package com.hogwarts.inventoryservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hogwarts.inventoryservice.entity.Inventory;
import com.hogwarts.inventoryservice.entity.client.ProductClient;
import com.hogwarts.inventoryservice.entity.dto.ProductDto;
import com.hogwarts.inventoryservice.repository.InventoryRepository;
import com.hogwarts.inventoryservice.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private ProductClient productClient;


	@Override
	public Inventory updateInventory(Inventory inventory) {
		ProductDto productDto = productClient.getProductById(inventory.getProductId());
		if(productDto == null) {
			throw new RuntimeException("Product Not Found");
		}
		inventory.setProductName(productDto.getName());
		Optional<Inventory> inventoryOpt = inventoryRepository.findById(inventory.getProductId());
		if (inventoryOpt.isPresent()) {
			Inventory existingInventory = inventoryOpt.get();
			existingInventory.setQuantity(inventory.getQuantity());
			return inventoryRepository.save(existingInventory);
		} else {
			return inventoryRepository.save(inventory);
		}
	}

	@Override
	public Inventory getInventoryByProductId(Long productId) {

		return inventoryRepository.findById(productId).orElse(null);
	}

	@Override
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}
		
}
