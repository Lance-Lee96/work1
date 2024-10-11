package com.korea.product.dto;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {
	
	private int orderId;//주문번호
	private int productId;//상품 번호
	private String productName;//상품이름
	private int productCount;//주문개수
	private int productPrice;//상품가격
	private int totalPrice;//결제금액
	private String orderDate;//주문 날짜
	
	public static List<OrderDTO> toListOrderDTO(List<Object[]> list) {
		//Object[] 데이터를 OrderDTO로 변환
		//Object -> Integer -> int (언박싱)
		return list.stream().map(result -> OrderDTO.builder()
							.orderId((int)result[0])
							.productName((String)result[1])
							.productCount((int)result[2])
							.productPrice((int)result[3])
							.totalPrice((int)result[4])
							.orderDate((String)result[5])
							.build()).collect(Collectors.toList());
	}
	
}
