package com.example.bookingservice.service.impl;

import com.example.bookingservice.dto.BookingInfoEntity;
import com.example.bookingservice.dto.BookingRequest;
import com.example.bookingservice.dto.BookingResponse;
import com.example.bookingservice.dto.TransactionRequest;
import com.example.bookingservice.feign.PaymentServiceClient;
import com.example.bookingservice.repository.BookingRepository;
import com.example.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private PaymentServiceClient paymentServiceClient;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public BookingInfoEntity getBookingInfoService(BookingRequest request) {
        BookingInfoEntity bookingInfoEntity = new BookingInfoEntity();
        long numberOfDays = DAYS.between(request.getFromDate(), request.getToDate());
        bookingInfoEntity.setFromDate(request.getFromDate().atStartOfDay());
        bookingInfoEntity.setToDate(request.getFromDate().atStartOfDay());
        bookingInfoEntity.setRoomPrice(Integer.valueOf((int) (1000 * request.getNumOfRooms() * numberOfDays)));
        bookingInfoEntity.setAadharNumber(request.getAadharNumber());
        bookingInfoEntity.setRoomNumbers(getRandomNumbers(request.getNumOfRooms()).toString());
        bookingInfoEntity.setTransactionId(0);
        bookingInfoEntity.setBookedOn(LocalDateTime.now());
        bookingRepository.save(bookingInfoEntity);
        return bookingInfoEntity;
    }

    @Override
    public BookingResponse getBookingInfoForTransaction(Integer id, TransactionRequest request) {
        BookingResponse bookingResponse = new BookingResponse();
        if(request.getPaymentMode().equalsIgnoreCase("CARD") || request.getPaymentMode().equalsIgnoreCase("UPI")){
            Integer transactionId = paymentServiceClient.getData(request);
            Optional<BookingInfoEntity> bookingInfoEntityOptional = bookingRepository.findById(id);
            if(bookingInfoEntityOptional.isPresent()) {
                BookingInfoEntity bookingInfoEntity = bookingRepository.getOne(id);
                bookingInfoEntity.setTransactionId(transactionId);
                bookingRepository.save(bookingInfoEntity);
                bookingResponse.setId(bookingInfoEntityOptional.get().getId());
                bookingResponse.setFromDate(bookingInfoEntityOptional.get().getFromDate());
                bookingResponse.setToDate(bookingInfoEntityOptional.get().getToDate());
                bookingResponse.setAadharNumber(bookingInfoEntityOptional.get().getAadharNumber());
                bookingResponse.setRoomPrice(bookingInfoEntityOptional.get().getRoomPrice());
                bookingResponse.setTransactionId(transactionId);
                bookingResponse.setBookedOn(bookingInfoEntityOptional.get().getBookedOn());
            }else{
                bookingResponse.setMessage("Invalid Booking Id");
                bookingResponse.setStatusCode(400);
            }
            return bookingResponse;
        }else{
            bookingResponse.setMessage("Invalid mode of payment");
            bookingResponse.setStatusCode(404);
            return bookingResponse;
        }
    }

    public static ArrayList<String> getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String>numberList = new ArrayList<String>();
        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }
        return numberList;
    }

}
