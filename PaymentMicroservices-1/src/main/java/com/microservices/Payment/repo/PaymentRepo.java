package com.microservices.Payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.Payment.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

	Payment findByOrderId(int orderID);

}
