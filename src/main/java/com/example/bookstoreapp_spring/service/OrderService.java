package com.example.bookstoreapp_spring.service;

import com.example.bookstoreapp_spring.dto.OrderDTO;
import com.example.bookstoreapp_spring.exceptions.BookStoreCustomException;
import com.example.bookstoreapp_spring.model.CartData;
import com.example.bookstoreapp_spring.model.OrderData;
import com.example.bookstoreapp_spring.repository.OrderRepository;
import com.example.bookstoreapp_spring.service.ICartService;
import com.example.bookstoreapp_spring.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ICartService iCartService;

    @Autowired
    private TokenUtil tokenUtil;

    /***
     * Implemented placeOrder method to place orders
     * @param orderDTO - passing orderDTO param
     * @return
     */
    @Override
    public OrderData placeOrder(OrderDTO orderDTO) {
        CartData cartData = iCartService.getCartById(orderDTO.getCartId());
        int totalPrice = cartData.getTotalPrice();
        OrderData orderData = new OrderData(cartData, orderDTO);
        orderData.setGrandTotal(totalPrice);
        return orderRepository.save(orderData);
    }

    /***
     * Implemented getAllOrders method to find all orders
     * @return
     */
    @Override
    public List<OrderData> getAllOrders() {
        return orderRepository.findAll();
    }

    /***
     * Implemented getOrderById method to find order by id
     * @param orderId - passing orderId param
     * @return
     */
    @Override
    public OrderData getOrderById(int orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new BookStoreCustomException("Order with id " + orderId + " not found"));
    }

    /***
     * Implemented cancelOrder method to cancel an order
     * @param orderId - passing orderId param
     * @return
     */
    @Override
    public OrderData cancelOrder(int orderId) {
        OrderData orderData = this.getOrderById(orderId);
        orderData.setCancel(true);
        int bookQuantity = orderData.getCartId().getQuantity() + orderData.getCartId().getBookId().getQuantityLeft();
        orderData.getCartId().getBookId().setQuantityLeft(bookQuantity);
        orderData.getCartId().setQuantity(0);
        orderData.getCartId().setTotalPrice(0);
        orderData.setGrandTotal(0);
        return orderRepository.save(orderData);
    }

    /***
     * Implemented verifyOrder method to get the details of order
     * @param token - passing token param
     * @return
     */
    @Override
    public OrderData verifyOrder(String token) {
        OrderData orderData = this.getOrderById(tokenUtil.decodeToken(token));
        return orderRepository.save(orderData);
    }
}
