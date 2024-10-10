package com.example.FeignClient.ifaces;

import java.security.PublicKey;
import java.util.List;
import java.util.function.LongFunction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.FeignClient.model.Product;

//service name should be same as in value
@FeignClient(value = "productAPI-04-10-2024",url = "http://localhost:8085/products")
public interface feignclient {
	
	@GetMapping("/productsList")
	public List<Product>getallProducts();
	
	@GetMapping("/product/{id}")
	public Product getproductbyid(@PathVariable Long id);
	
	
	@DeleteMapping("/deleteproductlistbyid/{id}")
	public List<Product> deleteproductbyid(@PathVariable Long id);
	

}
