package com.blog.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BlopAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlopAppApiApplication.class, args);
	}
	
	
//	for mapping different models
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
