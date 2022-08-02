package com.example.paymentservice.controller;

import com.example.paymentservice.dto.TransactionDetailsEntity;
import com.example.paymentservice.dto.TransactionRequest;
import com.example.paymentservice.repository.TransactionRepository;
import com.example.paymentservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<Integer> getTranscationId(@RequestBody TransactionRequest request){
        Integer transactionId = transactionService.getTransactionIdResponse(request);
        return new ResponseEntity(transactionId, HttpStatus.OK);
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<TransactionDetailsEntity> getTransactionDetails(@PathVariable Integer transactionId){
        TransactionDetailsEntity transactionDetailsEntity = transactionService.getTransactionDetails(transactionId);
        return new ResponseEntity(transactionDetailsEntity, HttpStatus.OK);
    }
}
