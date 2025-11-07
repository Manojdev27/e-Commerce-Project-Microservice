package com.hogwarts.inventoryservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hogwarts.inventoryservice.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{
	
	Optional<Inventory> findByProductId(Long productId);


}
