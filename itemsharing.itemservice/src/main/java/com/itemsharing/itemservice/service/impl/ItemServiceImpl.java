package com.itemsharing.itemservice.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.Usuario;
import com.itemsharing.itemservice.repository.ItemRepository;
import com.itemsharing.itemservice.service.ItemService;
import com.itemsharing.itemservice.service.UserService;

@Service
public class ItemServiceImpl implements ItemService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserService userService;
	

	@Override
	public Item addItemByUsuario(Item item, String username) {
		
		Item localItem = itemRepository.findByName(item.getName());
		
		if(localItem != null) {
			LOG.info("Item with name {} already exists. Nothing will be done", item.getName());
			return null;
		} else {
			Date today = new Date();
			item.setAddDate(today);
			
			Usuario usuario = userService.findByUsername(username);
			item.setUser(usuario);
			Item newItem = itemRepository.save(item);
			return newItem;
		}
		
	}

	@Override
	public List<Item> getAllItems() {
		return (List<Item>)itemRepository.findAll();
	}

	@Override
	public List<Item> getItemsByUsername(String username) {
		Usuario user = userService.findByUsername(username);
		return (List<Item>) itemRepository.findByUser(user);
	}

	@Override
	public Item getItemById(Long id) {
		return itemRepository.findOne(id);
	}

	@Override
	public Item updateItem(Item item) throws IOException {
		Item localItem = getItemById(item.getId());
		
		if(localItem == null) {
			throw new IOException("Item was not found");
		} else {
			localItem.setName(item.getName());
			localItem.setItemCondition(item.getItemCondition());
			localItem.setStatus(item.getStatus());
			localItem.setDescription(item.getDescription());
		}
		return itemRepository.save(localItem);
	}

	@Override
	public void deleteItemById(Long id) {
		itemRepository.delete(id);
	}

	@Override
	public Usuario getUsuarioByUsername(String username) {
		return userService.findByUsername(username);
	}

}
