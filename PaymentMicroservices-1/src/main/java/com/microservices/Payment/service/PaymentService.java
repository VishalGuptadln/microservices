package com.microservices.Payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.Payment.entity.Payment;
import com.microservices.Payment.repo.PaymentRepo;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	public Payment doPayment(Payment payment)
	{
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return this.paymentRepo.save(payment);
	}
	
	
	public String paymentProcessing()
	{
		return new Random().nextBoolean()?"success":"false";
	}


	public Payment findPaymentHistoryByOrderId(int orderID) {
		
		return paymentRepo.findByOrderId(orderID);
	}

}
