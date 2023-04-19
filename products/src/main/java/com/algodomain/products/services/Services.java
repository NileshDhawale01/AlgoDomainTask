package com.algodomain.products.services;

import java.util.List;

import com.algodomain.products.pojo.Product;

public interface Services {

	Product add(Product product);

	Product find(int id);

	void delete(Product product);

	List<Product> getAllProduct();

	FinalPrice findCharges(Product product);

}
