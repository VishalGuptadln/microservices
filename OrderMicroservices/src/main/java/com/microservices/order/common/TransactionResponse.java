package com.microservices.order.common;

import com.microservices.order.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

	private Order order;
	private Payment paymet;
	private String message;
	
}
