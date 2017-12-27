package com.itemsharing.itemservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.Usuario;
import com.itemsharing.itemservice.service.ItemService;
import com.itemsharing.itemservice.service.UserService;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class ItemServiceApplication implements CommandLineRunner {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;

	public static void main(String [] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Usuario usuario = userService.findByUsername("jadams");
		
		Item item1 = new Item();
		item1.setName("Item 1");
		item1.setItemCondition("New");
		item1.setStatus("Active");
		item1.setAddDate(new Date());
		item1.setDescription("This is an item description");
		item1.setUser(usuario);
		
		itemService.addItemByUsuario(item1, usuario.getUsername());
		
		Item item2 = new Item();
		item2.setName("Item 2");
		item2.setItemCondition("Used");
		item2.setStatus("Inactive");
		item2.setAddDate(new Date());
		item2.setDescription("This is an item description for item 2");
		item2.setUser(usuario);
		
		itemService.addItemByUsuario(item2, usuario.getUsername());
		
		
	}
	
}
