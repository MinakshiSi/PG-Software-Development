package com.example.bookingservice.controller;

import com.example.bookingservice.dto.BookingInfoEntity;
import com.example.bookingservice.dto.BookingRequest;
import com.example.bookingservice.dto.BookingResponse;
import com.example.bookingservice.dto.TransactionRequest;
import com.example.bookingservice.feign.PaymentServiceClient;
import com.example.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class BookingController {

    @Autowired
    private PaymentServiceClient paymentServiceClient;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<BookingInfoEntity> getBookingInfoDetails(@RequestBody BookingRequest request){
        return new ResponseEntity(bookingService.getBookingInfoService(request), HttpStatus.CREATED);
    }

    @PostMapping("/booking/{id}/transaction")
    public ResponseEntity<BookingResponse> getBookingInfoForTransactionDetails(@PathVariable Integer id,
                                                                               @RequestBody TransactionRequest transaction){
        return new ResponseEntity(bookingService.getBookingInfoForTransaction(id, transaction), HttpStatus.OK);
    }
}
