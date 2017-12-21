package com.itemsharing.itemservice.controller;

import java.io.IOException;
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

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.Usuario;
import com.itemsharing.itemservice.service.ItemService;
import com.itemsharing.itemservice.service.UserService;

@RestController
@RequestMapping("/v1/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public Item addItem(@RequestBody Item item) {
		String username = "jadams";
		
		return itemService.addItemByUsuario(item, username);
	}
	
	@GetMapping("/itemByUser")
	public List<Item> getAllItemsByUser() {
		String username = "jadams";
		return itemService.getItemsByUsername(username);
	}
	
	@GetMapping("/all")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	@GetMapping("/{id}")
	public Item getItemById(@PathVariable Long id) {
		return itemService.getItemById(id);
	}
	
	@PutMapping("/{id}")
	public Item updateItem (@PathVariable Long id, @RequestBody Item item) throws IOException {
		item.setId(id);
		return itemService.updateItem(item);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItemById(@PathVariable Long id) throws IOException {
		itemService.deleteItemById(id);
	}
	
	@GetMapping("/user/{username}")
	public Usuario getUsuarioByUsername(@PathVariable String username) {
		return itemService.getUsuarioByUsername(username);
	}
	
	
	
	

}
