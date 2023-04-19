package com.algodomain.products.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.algodomain.products.pojo.Charges;

public interface CharrgeRepository extends  CrudRepository<Charges, String>{

	//custom made query --> for finding record using string
	public List<Charges> findByProductCategory(String category);
}
