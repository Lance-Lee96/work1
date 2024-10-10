package com.korea.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.product.dto.ProductDTO;
import com.korea.product.model.ProductEntity;
import com.korea.product.persistance.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;
	
	public List<ProductDTO> findAll() {
		//DB에 접근해서 데이터를 조회
		List<ProductEntity> list = productRepository.findAll();
		//리스트 안에 들어있는 Entity들을 DTO 로 변경
		List<ProductDTO> dtos = list.stream().map(ProductDTO::new).collect(Collectors.toList());

		return dtos;
		
	}
	
	public List<ProductDTO> create(ProductDTO dto) {
		ProductEntity entity = ProductDTO.toEntity(dto);
		productRepository.save(entity);
		
		return findAll();

	}
	
	
}
