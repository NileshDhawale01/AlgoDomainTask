package com.algodomain.products.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Charges {

	@Id
	private String productCategory;
	private double discount;
	private double gst;
	private double deliveyCharge;
	
	
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getDeliveyCharge() {
		return deliveyCharge;
	}
	public void setDeliveyCharge(double deliveyCharge) {
		this.deliveyCharge = deliveyCharge;
	}
	
}