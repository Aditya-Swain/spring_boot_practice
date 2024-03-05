package com.org.springdatajp104.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.springdatajp104.dto.Item;
import com.org.springdatajp104.repository.ItemRepository;

@Component
public class ItemDao {
	
	@Autowired
	ItemRepository repo;
	
	
	public Item saveItem(Item item) {
		return repo.save(item);
	}
	
	public List<Item> fetchAllItem(){
		
		return repo.findAll();
	}
	
	public Item fetchById(int id) {
		Optional<Item> optional = repo.findById(id);
		if(optional != null)
			return optional.get();
		return null;
	}
	
	
	public Item deleteById(int id) {
		Item item = fetchById(id);
		
		repo.delete(item);
		return item;
	}
	
	public List<Item> fetchByName(String name){
		return repo.findByItemName(name);
		
	}
	
	public List<Item> fetchByNameAndBrand(String name, String brand){
		return repo.findByItemNameAndItemBrand(name, brand);
	}
	
	public List<Item> fetchByBudget(int price){
		return repo.findByBudget(price);
	}
	
	
	
	
	
	
	
	
	
	
}
