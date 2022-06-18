package com.example.bookstoreapp_spring.service;

import com.example.bookstoreapp_spring.dto.CartDTO;
import com.example.bookstoreapp_spring.model.CartData;


public interface ICartService {
    CartData addToCart(CartDTO cartDTO);

    Iterable<CartData> findAllCarts();

    CartData getCartById(int cartId);

    CartData updateQuantity(int cartId, int quantity);

    void deleteCart(int cartId);
}