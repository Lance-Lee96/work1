package com.korea.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.product.dto.ProductDTO;
import com.korea.product.model.ProductEntity;
import com.korea.product.persistance.ProductRepository;


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
	public ProductDTO updateProduct(int id, ProductDTO dto){
		//db에 id에 해당하는 데이터가 있는지 조회
		Optional<ProductEntity> original = repository.findById(id);
		
		//있으면 매개변수로 넘어온 dto에 있는 내용으로 기존의 내용을 갱신
		if(original.isPresent()) {
			ProductEntity entity = original.get();
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			entity.setPrice(dto.getPrice());
			repository.save(entity);
			return new ProductDTO(entity);
		}
		return null;
		
//		exist.ifPresent(productEntity ->{
//			
//			productEntity.setName(dto.getName());
//			productEntity.setDescription(dto.getDescription());
//			productEntity.setPrice(dto.getPrice());
//			
//			repository.save(productEntity);
//		});
//		
	}
	
	//상품 삭제
	public boolean deleteProduct(int id) {
		Optional<ProductEntity> deleteEntity = repository.findById(id);
		
		if(deleteEntity.isPresent()) {
			repository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	
}
