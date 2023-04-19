package com.algodomain.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algodomain.products.pojo.Charges;
import com.algodomain.products.pojo.Product;
import com.algodomain.products.repository.CharrgeRepository;
import com.algodomain.products.repository.ProduRepository;

@Service
public class ProductServices implements Services{

	private double discount;
	private double gst;
	private double delivery;
	private double finalPrice1;
	@Autowired
	private ProduRepository repository;
	@Autowired
	private CharrgeRepository repository2;
	//add new product // update project
	public Product add(Product product) {
		Product  pro = repository.save(product);
		return pro;
	}
	
	//finding product to update //delete
	@Override
	public Product find(int id) {
		Optional<Product> product=  repository.findById(id);
		//setting values
		Product pro=product.get();
		return pro;
	}

	//delete record
	@Override
	public void delete(Product product) {
		repository.delete(product);
	}

	//getting list of all products
	@Override
	public List<Product> getAllProduct() {
		return repository.findAll();
	}

	//getting product final price
	@Override
	public FinalPrice findCharges(Product product) { //----products
		System.out.println(product.getProductCategory());
		List<Charges>charges = repository2.findByProductCategory(product.getProductCategory());
		//extracting Object of Category from list
		Charges charge = null;
		for(Charges charge1 :charges) {
			charge = charge1;
		}
		//scale controller 
		double scale = Math.pow(10, 2);//for only two decimal
		//finding exact values for product
		//discount//GST//delivery
		discount=Math.round((charge.getDiscount()/100)*product.getProductPrice()*scale)/scale;
		gst = Math.round((charge.getGst()/100)*(product.getProductPrice()-discount)*scale)/scale;
		delivery=Math.round(charge.getDeliveyCharge()*scale)/scale;
//		System.out.println("Discaunt --> "+(discount+2)+"\nGSt-->"+gst+"\nDelevery-->"+delivery);
		//creating charges for particular product
		
		Charges totalCharge = new Charges();//----charges
		
		totalCharge.setDeliveyCharge(delivery);
		totalCharge.setDiscount(discount);
		totalCharge.setGst(gst);
		//totalCharge.setProductCategory(null);
		//finding finalPrice
//		System.out.println("Product price :"+((product.getProductPrice())-(discount+gst+delivery)));
		finalPrice1 = product.getProductPrice()+gst+delivery-discount;//----price
		//set finalPrice to FinalPrice
		FinalPrice finalPrice = new FinalPrice();
		finalPrice.finalOperation(product.getProductCategory(),product.getProductID(),product.getProductName(),product.getProductPrice(),product.getProductType(), finalPrice1, totalCharge);
		return finalPrice;
	}

}
