package com.example.bookingservice.feign;

import com.example.bookingservice.dto.TransactionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "PAYMENT-SERVICE",url = "http://localhost:9091")
public interface PaymentServiceClient {
    @RequestMapping(method = RequestMethod.POST, value = "/payment/transaction", consumes = "application/json")
    Integer getData(@RequestBody TransactionRequest transactionRequest);
}
