package com.example.paymentservice.service;

import com.example.paymentservice.dto.TransactionDetailsEntity;
import com.example.paymentservice.dto.TransactionRequest;

public interface TransactionService {
    Integer getTransactionIdResponse(TransactionRequest request);
    TransactionDetailsEntity getTransactionDetails(Integer transactionId);
}
