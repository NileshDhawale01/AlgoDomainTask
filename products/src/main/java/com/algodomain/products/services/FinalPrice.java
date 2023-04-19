package com.algodomain.products.services;

import org.springframework.stereotype.Service;

import com.algodomain.products.pojo.Charges;
import com.algodomain.products.pojo.Product;

@Service
public class FinalPrice {

	private Product product;
	private Charges charges;
	private double finalPrice;
	
	public void finalOperation(String category,int productId,String productName,long productPrice,String productType,double finalPrice,Charges charges) {
		//product setting
		product =  new Product();
		this.product.setProductCategory(category);
		this.product.setProductID(productId);
		this.product.setProductName(productName);
		this.product.setProductPrice(productPrice);
		this.product.setProductType(productType);
		//charges setting
		this.charges=charges;
		//final price setting
		this.finalPrice = finalPrice;
		}
	
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Charges getCharges() {
		return charges;
	}
	public void setCharges(Charges charges) {
		this.charges = charges;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	

}
