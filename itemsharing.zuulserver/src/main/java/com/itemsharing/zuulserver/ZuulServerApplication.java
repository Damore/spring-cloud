package com.itemsharing.zuulserver;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import com.itemsharing.zuulserver.util.UserContextInterceptor;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication {
	
	//spring.sleuth.sampler.percentage 1.0
	@Bean
	public Sampler defaultSampler() {
		return new AlwaysSampler();	
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate template = new RestTemplate();
		java.util.List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
		
		if(interceptors == null) {
			template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
		} else {
			interceptors.add(new UserContextInterceptor());
			template.setInterceptors(interceptors);
		}
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}
	
}
