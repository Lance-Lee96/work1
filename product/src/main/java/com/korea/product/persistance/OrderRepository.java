package com.korea.product.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.korea.product.model.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

	//총 결제 금액
	//상풍가격 * 주문개수
	@Query("select o.orderID, "
			+ "o.product.productName, "
			+ "o.productCount, "
			+ "o.product.productPrice, "
			+ "(o.product.productPrice * o.productCount) AS totalPrice "
			+ "from OrderEntity o")
	List<Object[]> findAllOrderTotalPrices(); 
	
}
