package com.example.bookstoreapp_spring.service;

import com.example.bookstoreapp_spring.dto.ResponseDTO;
import com.example.bookstoreapp_spring.model.EmailData;
import org.springframework.http.ResponseEntity;

public interface IEmailService {
    ResponseEntity<ResponseDTO> sendEmail(EmailData emailData);

    String getLink(String token);

    String getOrderLink(String token);
}