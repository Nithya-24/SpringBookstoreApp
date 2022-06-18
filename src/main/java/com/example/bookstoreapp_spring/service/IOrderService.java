package com.example.bookstoreapp_spring.service;

import com.example.bookstoreapp_spring.dto.OrderDTO;
import com.example.bookstoreapp_spring.model.BookData;
import com.example.bookstoreapp_spring.model.OrderData;

import java.util.List;

public interface IOrderService {
    OrderData placeOrder(OrderDTO orderDTO);

    List<OrderData> getAllOrders();

    OrderData getOrderById(int orderId);

    OrderData cancelOrder(int orderId);

    OrderData verifyOrder(String token);
}
