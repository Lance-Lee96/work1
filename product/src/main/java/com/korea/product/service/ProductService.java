package com.korea.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.product.dto.ProductDTO;
import com.korea.product.model.ProductEntity;
import com.korea.product.persistance.ProductRepository;
import com.korea.user.model.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
	private final ProductRepository repository;
	
	//상품 추가
	public ProductDTO addProduct(ProductDTO productDTO){
		//넘어온 DTO를 Entity로 변환
		ProductEntity entity = ProductDTO.toEntity(productDTO);
		//Entity를 db에 추가하고 DTO로 변환하여 반환 
		return new ProductDTO(repository.save(entity));
		}
	//상품 조회
	public List<ProductDTO> getFilteredProducts(Double minPrice, String name){
		List<ProductEntity> products = repository.findAll();
		
		//가격 필터링(최소 금액이 주어진 경우)
		if(minPrice != null) {
			products = products.stream().filter(product -> product.getPrice() >= minPrice).collect(Collectors.toList());
			
		}
		
		//이름 필터링(name이 넘어왔을 경우)
		if(name != null && !name.isEmpty()) {
			products = products.stream()
							.filter(product -> product.getName().toLowerCase()
							.contains(name.toLowerCase()))
							.collect(Collectors.toList());
		}
		return products.stream().map(ProductDTO::new).collect(Collectors.toList());
	}
	
	//상품 수정
	public List<ProductDTO> updateProduct(ProductEntity entity){
		Optional<ProductEntity> exist = repository.findById(entity.getId());
		exist.ifPresent(productEntity ->{
			productEntity.setName(entity.getName());
			productEntity.setDescription(entity.getDescription());
			productEntity.setPrice(entity.getPrice());
			
			repository.save(productEntity);
		});
		return
		
	}
	
	
}
