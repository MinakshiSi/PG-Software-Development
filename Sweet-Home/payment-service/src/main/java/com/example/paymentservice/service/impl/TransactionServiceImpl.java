package com.example.paymentservice.service.impl;

import com.example.paymentservice.dto.TransactionDetailsEntity;
import com.example.paymentservice.dto.TransactionRequest;
import com.example.paymentservice.repository.TransactionRepository;
import com.example.paymentservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Integer getTransactionIdResponse(TransactionRequest request) {
        TransactionDetailsEntity transactionDetailsEntity = new TransactionDetailsEntity();
            transactionDetailsEntity.setBookingId(request.getBookingId());
            transactionDetailsEntity.setCardNumber(request.getCardNumber());
            transactionDetailsEntity.setPaymentMode(request.getPaymentMode());
            transactionDetailsEntity.setUpiId(request.getUpiId());
        transactionRepository.save(transactionDetailsEntity);
        TransactionDetailsEntity transactionId = transactionRepository.getOne(request.getBookingId());
        return transactionId.getId();
    }

    @Override
    public TransactionDetailsEntity getTransactionDetails(Integer transactionId) {
        Optional<TransactionDetailsEntity> transactionDetailsEntity = transactionRepository.findById(transactionId);
        TransactionDetailsEntity transactionDetailsEntity1 = new TransactionDetailsEntity();
        if (transactionDetailsEntity.isPresent()){
                transactionDetailsEntity1.setId(transactionDetailsEntity.get().getId());
                transactionDetailsEntity1.setBookingId(transactionDetailsEntity.get().getBookingId());
                transactionDetailsEntity1.setCardNumber(transactionDetailsEntity.get().getCardNumber());
                transactionDetailsEntity1.setUpiId(transactionDetailsEntity.get().getUpiId());
                transactionDetailsEntity1.setPaymentMode(transactionDetailsEntity.get().getPaymentMode());
            }
        return transactionDetailsEntity1;
    }
}
