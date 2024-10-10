package com.example.productAPI_04_10_2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProductApi04102024Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductApi04102024Application.class, args);
	}

}
