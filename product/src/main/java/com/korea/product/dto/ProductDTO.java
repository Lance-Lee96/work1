package com.korea.product.dto;

import java.time.LocalDateTime;

import com.korea.product.model.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
	
	private int productId;
	private String productName;
	private int productStock;
	private int productPrice;
	private LocalDateTime registerDate;
	private LocalDateTime updateDate;
	
	public ProductDTO(ProductEntity entity) {
		this.productId = entity.getProductId();
		this.productName = entity.getProductName();
		this.productStock = entity.getProductStock();
		this.productPrice = entity.getProductPrice();
		this.registerDate = entity.getRegisterDate();
		this.updateDate = entity.getUpdateDate();
	}
	
	public static ProductEntity toEntity(ProductDTO dto) {
		return ProductEntity.builder()
				.productId(dto.productId)
				.productName(dto.productName)
				.productStock(dto.productStock)
				.productPrice(dto.productPrice)
				.registerDate(dto.registerDate)
				.updateDate(dto.updateDate)
				.build();
	}
	
	
}
