package com.example.bookstoreapp_spring.repository;

import com.example.bookstoreapp_spring.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderData, Integer> {
}
