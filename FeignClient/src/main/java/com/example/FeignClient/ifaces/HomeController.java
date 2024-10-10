package com.example.FeignClient.ifaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FeignClient.model.Product;

@RestController
@RequestMapping("/client")
public class HomeController {
	
	@Autowired
	private feignclient feignclient;
	
	
	@GetMapping("/getproducts")
	public List<Product>getAll(){
		return feignclient.getallProducts();
	}
	
	@GetMapping("/findproduct/{id}")
	public Product getproductbyid(@PathVariable Long id) {
		return feignclient.getproductbyid(id);
	}
	
	@DeleteMapping("/deleteproductbyid/{id}")
	public List<Product> deleteproductbyid(@PathVariable Long id){
		return feignclient.deleteproductbyid(id);
	}

}
