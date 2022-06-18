package com.example.bookstoreapp_spring.repository;

import com.example.bookstoreapp_spring.model.CartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartData, Integer> {
}