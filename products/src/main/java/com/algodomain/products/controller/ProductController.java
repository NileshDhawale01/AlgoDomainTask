package com.algodomain.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.algodomain.products.pojo.Product;
import com.algodomain.products.services.FinalPrice;
import com.algodomain.products.services.Services;

@RestController
public class ProductController {

	@Autowired
	private Services services;
	
	//for adding new product
	@PostMapping("/addRecord")
	public Product addRecord(@RequestBody Product product) {
		//adding product
		Product pro = services.add(product);
		//success
		if(pro != null) {
		return pro;
		}
		//fail
		return null;
	}
	
	//update record
	@PostMapping("/update")
	public Product update(@RequestBody Product product) {
		int id = product.getProductID();
		Product pro = services.find(id);
		//updating values
		pro.setProductID(product.getProductID());
		pro.setProductName(product.getProductName());
		pro.setProductCategory(product.getProductCategory());
		pro.setProductType(product.getProductType());
		pro.setProductPrice(product.getProductPrice());
		Product product2= services.add(pro);
		return product2;
	}
	
	//delete record
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		//find by id
		int id1 = Integer.parseInt(id);
		Product product = services.find(id1);
		services.delete(product);
		return "Product Deleted...";
	}
	
	//getting all product --> checking purpose
	@GetMapping("/products")
	public List<Product> getAllProduct(){
		List<Product> productList =services.getAllProduct();
		return productList;
	}
	
	//getProducts --> This method will calculate the final price
	// of products
	@PostMapping("/getProducts/{id}")
	public FinalPrice getProducts(@PathVariable String id){
		int id1 = Integer.parseInt(id);
		Product product = services.find(id1);
		FinalPrice price = services.findCharges(product);
		return price;
	}
}
