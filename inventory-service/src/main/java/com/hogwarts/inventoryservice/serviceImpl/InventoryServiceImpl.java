package com.hogwarts.inventoryservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hogwarts.inventoryservice.entity.Inventory;
import com.hogwarts.inventoryservice.entity.client.ProductClient;
import com.hogwarts.inventoryservice.entity.dto.InventoryDto;
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
	public Inventory updateInventory(InventoryDto inventoryDto) {
	    // Fetch product details from product service using productId
	    ProductDto productDto = productClient.getProductById(inventoryDto.getProductId());
	    if (productDto == null) {
	        throw new RuntimeException("Product Not Found");
	    }
	    
	    // Attempt to fetch existing inventory by productId
	    Optional<Inventory> inventoryOpt = inventoryRepository.findById(inventoryDto.getProductId());

	    Inventory inventoryToSave;
	    if (inventoryOpt.isPresent()) {
	        // Inventory exists, update quantity and productName
	        inventoryToSave = inventoryOpt.get();
	        inventoryToSave.setQuantity(inventoryDto.getQuantity());
	    } else {
	        // No inventory exists, create new
	        inventoryToSave = new Inventory();
	        inventoryToSave.setProductId(inventoryDto.getProductId());
	        inventoryToSave.setQuantity(inventoryDto.getQuantity());
	    }

	    // Set/update productName from productDto
	    inventoryToSave.setProductName(productDto.getName());

	    // Save and return the updated/new inventory
	    return inventoryRepository.save(inventoryToSave);
	}

	@Override
	public Optional<Inventory> getInventoryByProductId(Long productId) {
		 Optional<Inventory> optId = inventoryRepository.findByProductId(productId);
		return optId;
	}

	@Override
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}

	@Override
	public Inventory inventoryPut(Long productId, InventoryDto inventoryDto) {
		ProductDto productDto = productClient.getProductById(inventoryDto.getProductId());
		Inventory existingInventory = inventoryRepository.findByProductId(productId)
				.orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));;
				existingInventory.setProductId(inventoryDto.getProductId());
				existingInventory.setQuantity(inventoryDto.getQuantity());
				existingInventory.setProductName(productDto.getName());
				Inventory savedInventory = inventoryRepository.save(existingInventory);
		return savedInventory;
	}
		
}
