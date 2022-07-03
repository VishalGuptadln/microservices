package com.microservices.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.order.common.Payment;
import com.microservices.order.common.TransactionRequest;
import com.microservices.order.common.TransactionResponse;
import com.microservices.order.entity.Order;
import com.microservices.order.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(TransactionRequest transactionRequest)
	{
		
		Order order=transactionRequest.getOrder();
		Payment payment=transactionRequest.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		System.out.println("inside order service");
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		
		String message = paymentResponse.getPaymentStatus().equals("success")?"Payment has successful":"Payment not completed ";
		
		this.orderRepo.save(order);
		return new TransactionResponse(order, paymentResponse , message);
	}
}
