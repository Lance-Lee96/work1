package com.korea.product.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="product")
public class ProductEntity {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int productId;
	private String productName;
	private int productStock;
	private int productPrice;
	
	@CreationTimestamp //Insert 쿼리가 발생할 때 시간 값을 적용시켜준다.
	private LocalDateTime registerDate;
	
	@UpdateTimestamp //Update쿼리가 발생했을 때 시간 값을 적용시켜준다.
	//LocalDateTime.now() : 현재 시간을 저장
	private LocalDateTime updateDate = LocalDateTime.now();
	
	
}
