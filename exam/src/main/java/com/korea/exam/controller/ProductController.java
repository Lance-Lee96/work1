package com.korea.exam.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.exam.dto.ProductDTO;
import com.korea.exam.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO dto){
		ProductDTO createProduct = productService.addProduct(dto);
		return ResponseEntity.ok().body(createProduct);
	}
	
	@GetMapping
	public ResponseEntity<?> getProducts() {
		List<ProductDTO> products = productService.getProducts();
		return ResponseEntity.ok().body(products);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getById(@PathVariable long id) {
	    ProductDTO g_product = productService.getById(id);
	    return ResponseEntity.ok(g_product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable long id, @RequestBody ProductDTO dto){
		ProductDTO u_dto = productService.updateProduct(id, dto);
		if(u_dto != null) {
			return ResponseEntity.ok().body(u_dto);
		}else {
			return ResponseEntity.badRequest().body("Update Failed");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable long id){
		Boolean d_dto = productService.deleteProduct(id);
		if(d_dto == true) {
			return ResponseEntity.ok("Deleted");
		}else {
			return ResponseEntity.badRequest().body("Id not found");
		}
	}
	
	
	
	
}
