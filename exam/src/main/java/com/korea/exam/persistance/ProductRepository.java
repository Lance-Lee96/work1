package com.korea.exam.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korea.exam.model.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

	ProductEntity findById(long id);

	void deleteById(long id);
	
	
	
	
}
