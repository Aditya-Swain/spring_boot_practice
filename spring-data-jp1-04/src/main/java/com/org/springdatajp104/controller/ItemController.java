package com.org.springdatajp104.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springdatajp104.dao.ItemDao;
import com.org.springdatajp104.dto.Item;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemDao dao;
		
	@PostMapping
	public Item saveItem(@RequestBody Item item) {
		return dao.saveItem(item);
	}
	
	@PutMapping("/{id}")
	public Item updateItem(@RequestBody Item item, @PathVariable int id) {
		
		Item item2 = dao.fetchById(id);
		
		if(item2!=null) {
			item.setId(item2.getId());
			dao.saveItem(item);
		}
		return item;
	}
	
	
	@GetMapping
	public List<Item> fetchAllItem(){
		return dao.fetchAllItem();
	}
	
	@GetMapping("/{id}")
	public Item fetchItemById(@PathVariable int id) {
		return dao.fetchById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteItemById(@PathVariable int id) {
		dao.deleteById(id);
		return "item deleted successfully";
	}
	@GetMapping("/byName/{name}")
	public List<Item> fetchByItemName(@PathVariable String name){
		return dao.fetchByName(name);
		
	}
	
	@GetMapping("/{name}/{brand}")
	public List<Item> fetItemByNameAndBrand(@PathVariable String name ,@PathVariable String brand){
		return dao.fetchByNameAndBrand(name, brand);
	}
	
	@GetMapping("/byPrice/{price}")
	public List<Item> fetchByBudget(@PathVariable int price){
		return dao.fetchByBudget(price);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
