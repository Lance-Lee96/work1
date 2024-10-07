package com.korea.exam.dto;

import com.korea.exam.model.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private long id;
	private String name;
	private double price;
	private int stock;
	
	public ProductDTO (ProductEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.price = entity.getPrice();
		this.stock = entity.getStock();
	}
	
	public static ProductEntity toEntity(ProductDTO dto) {
		return ProductEntity.builder().id(dto.getId()).name(dto.getName()).price(dto.getPrice()).stock(dto.getStock()).build();
	}
}
