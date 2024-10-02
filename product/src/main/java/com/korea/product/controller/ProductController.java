package com.korea.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//상품 수정
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductDTO dto){
		ProductDTO u_dto = service.updateProduct(id, dto);
		if(u_dto != null) {
			return ResponseEntity.ok().body(u_dto);
		}else {
			return ResponseEntity.badRequest().body("Update Failed");
		}
	}
	
	//상품 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id){
		Boolean d_dto = service.deleteProduct(id);
		if(d_dto == true) {
			return ResponseEntity.ok("Deleted");
		}else {
			return ResponseEntity.badRequest().body("Id not found");
		}
	}

}
