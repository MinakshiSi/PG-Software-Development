package com.example.bookingservice.service;

import com.example.bookingservice.dto.BookingInfoEntity;
import com.example.bookingservice.dto.BookingRequest;
import com.example.bookingservice.dto.BookingResponse;
import com.example.bookingservice.dto.TransactionRequest;

public interface BookingService {
    BookingInfoEntity getBookingInfoService(BookingRequest request);
    BookingResponse getBookingInfoForTransaction(Integer id, TransactionRequest transaction);
}
