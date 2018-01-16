package com.itemsharing.zipkingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkingserverApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ZipkingserverApplication.class, args);
	}

}
