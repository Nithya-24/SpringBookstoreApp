package com.example.bookstoreapp_spring.dto;

import lombok.Data;

public @Data class OrderDTO {
    public int cartId;
    public String address;
}