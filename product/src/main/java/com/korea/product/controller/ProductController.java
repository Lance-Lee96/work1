package com.korea.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.dto.ProductDTO;
import com.korea.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {
	
	private final ProductService service;
	
	//상품추가
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO dto){
		ProductDTO createProduct = service.addProduct(dto);
		return ResponseEntity.ok().body(createProduct);
		
	}
	
	@GetMapping
	public ResponseEntity<?> getFilteredProducts(
			@RequestParam(value="minPrice", required=false) Double minPrice,
			@RequestParam(value="name", required=false) String name){
		List<ProductDTO> products = service.getFilteredProducts(minPrice, name);
		return ResponseEntity.ok().body(products);
		
	}
	

}
