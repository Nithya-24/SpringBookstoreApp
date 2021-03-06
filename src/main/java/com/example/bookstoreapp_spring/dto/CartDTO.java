package com.example.bookstoreapp_spring.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public @Data class CartDTO {
    public int userId;
    public int bookId;
    public int quantity;
}