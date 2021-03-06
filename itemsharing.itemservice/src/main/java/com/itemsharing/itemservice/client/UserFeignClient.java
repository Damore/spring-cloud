package com.itemsharing.itemservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itemsharing.itemservice.model.Usuario;

@FeignClient("userservice")
public interface UserFeignClient {
	
	@RequestMapping(value="v1/user/{username}", consumes = "application/json")
	Usuario getUserByUsername(@PathVariable("username") String username);
	
}
