package com.microservices.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.order.common.Payment;
import com.microservices.order.common.TransactionRequest;
import com.microservices.order.common.TransactionResponse;
import com.microservices.order.entity.Order;
import com.microservices.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderConroller {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest transactionRequest)
	{
		return this.orderService.saveOrder(transactionRequest);
	}
	
}
