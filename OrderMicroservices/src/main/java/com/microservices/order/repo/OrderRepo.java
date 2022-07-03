package com.microservices.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.order.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
