package com.example.productAPI_04_10_2024.controllers;

import com.example.productAPI_04_10_2024.model.ProductModel;
import com.example.productAPI_04_10_2024.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController // RESTCONTROLLER=Controller+Body //Spring MVC-Response-we return a ViewResolver-write to body of the html
@RequestMapping("/products")
public class Product {



    @Autowired
    Productservice productservice;

    ArrayList<ProductModel> productsList = new ArrayList<ProductModel>();
    {

        productsList.add(new ProductModel(101,"Nike","good",10,15000));
        productsList.add(new ProductModel(102,"Puma","good",20,15045));
    }


    @GetMapping("/")
    public String Greet(){
        return "Hello product application";
    }

    @GetMapping("/productsList")
    public ArrayList<ProductModel> getArrayproductList(){
        return productsList;
    }
    
    @DeleteMapping("/deleteproductlistbyid/{id}")
    public List<ProductModel> deleteproductlistbyids(@PathVariable Long id){
    	
    	return (List<ProductModel>) productsList.stream().filter(product->product.getProductId() !=id).collect(Collectors.toList());
    }

    @GetMapping(value = "/product/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ProductModel> getByID(@PathVariable Long id){
        Optional<ProductModel>optional = productsList.stream().filter(product->product.getProductId()==id).findFirst();
        return ResponseEntity.ok().body(optional.get());
    }

    //strings comapreions use equals
    @GetMapping(value = "/product/brand/{brandname}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ProductModel> getBrandname(@PathVariable String brandname){
        Optional<ProductModel>optional = productsList.stream().filter(product->product.getBrand().equals( brandname)).findFirst();
        return ResponseEntity.ok().body(optional.get());
    }


    @PostMapping(value = "/addproducts",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductModel>addListProduct(@RequestBody ProductModel product){

        boolean flag = false;

        if(product!=null){
            flag =productsList.add(product);
        }

        if(flag){
           return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
        else {
           return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PostMapping("/addproduct")
    public ProductModel addproduct(@RequestBody ProductModel pord){
        return productservice.addProduct(pord);
    }

    @GetMapping(value = "/getproduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductModel>> getproduct(){
        return ResponseEntity.status(200).body(productservice.getallproducts());

    }

    @PutMapping("/updatemapping/{id}")
    public ProductModel updateproduct(@PathVariable long id , @RequestBody ProductModel prod){
        return productservice.updateproduct(id,prod);
    }

    @DeleteMapping("/deletemapping/{id}")
    public void deleteproduct(@PathVariable long id){
      productservice.deleteproduct(id);
    }



}
