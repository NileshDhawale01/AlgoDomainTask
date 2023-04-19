package com.algodomain.products.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algodomain.products.pojo.Product;
@Repository
public interface ProduRepository extends JpaRepository<Product, Integer> {

	//JpaRepository has all database crude methods
}
