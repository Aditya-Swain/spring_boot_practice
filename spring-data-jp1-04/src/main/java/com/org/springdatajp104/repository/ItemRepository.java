package com.org.springdatajp104.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.springdatajp104.dto.Item;

	public interface ItemRepository extends JpaRepository<Item,Integer>{
			
		List<Item> findByItemName(String itemName);
		
		List<Item> findByItemNameAndItemBrand(String itemName ,String itemBrand);
		
		@Query("SELECT i from Item i WHERE i.price<=?1")
		List<Item> findByBudget(int price);
		
		List<Item> findByPlatform(String platform);
}	
