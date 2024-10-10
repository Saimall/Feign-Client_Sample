package com.example.FeignClient.model;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;


  //generates all setters and getter and toString  and default constructor from lambok . if we dont want that we can say @setter and @getter . if we want constructour for all varaibles we can use @AllArgsConstructor
//this is used for deafult construtor


public class Product {
	 private Long productId;
		private String brand;
	    private  String description;
	    private  int qty;
	    private  int price;
	

	    
	    public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
		

	    public Product(Long productId, String brand, String description, int qty, int price) {
			super();
			this.productId = productId;
			this.brand = brand;
			this.description = description;
			this.qty = qty;
			this.price = price;
		}
	   
	


}
