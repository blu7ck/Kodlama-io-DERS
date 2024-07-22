package com.blu4ck.demo;

import com.blu4ck.demo.core.utilities.mappers.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentApplication.class, args);
	}

	@Bean
	public 	ModelMapper mapper(){
		return new ModelMapper();

	}
}
