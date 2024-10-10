package com.example.productAPI_04_10_2024.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;



  //generates all setters and getter and toString  and default constructor from lambok . if we dont want that we can say @setter and @getter . if we want constructour for all varaibles we can use @AllArgsConstructor
 //this is used for deafult construtor
@Entity
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;
    @Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", brand=" + brand + ", description=" + description + ", qty="
				+ qty + ", price=" + price + "]";
	}
	private String brand;
    private  String description;
    private  int qty;
    private  int price;
    
    public ProductModel(long i, String brand, String description, int qty, int price) {
		super();
		this.productId = i;
		this.brand = brand;
		this.description = description;
		this.qty = qty;
		this.price = price;
	}
	

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
	
}
