package com.korea.product.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="orders")
public class OrderEntity {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int orderID; //주문번호
	
	@ManyToOne //ProductEntity와 다대일 관계를 설정 , 외래키
	@JoinColumn(name="productId", nullable=false)
	private ProductEntity product; //상품 번호
	
	private int productCount; //주문 개수
	
	@CreationTimestamp
	private String orderDate; //주문날짜
	
	

}
