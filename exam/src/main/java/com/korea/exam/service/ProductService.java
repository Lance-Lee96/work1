package com.korea.exam.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korea.exam.dto.ProductDTO;
import com.korea.exam.model.ProductEntity;
import com.korea.exam.persistance.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public ProductDTO addProduct(ProductDTO dto) {
		ProductEntity productentity = ProductDTO.toEntity(dto);
		return new ProductDTO(repository.save(productentity));
	}
	
	public List<ProductDTO> getProducts(){
		 return repository.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
	}
	
	public ProductDTO getById(long id) {
	    ProductEntity entity = repository.findById(id);
	    return new ProductDTO(entity);
	}
	
	public ProductDTO updateProduct(long id, ProductDTO dto) {
		return  new ProductDTO();
	}
	
	public Boolean deleteProduct(long id) {
		return new ProductDTO();
}
}
	

