package com.example.paymentservice.repository;

import com.example.paymentservice.dto.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionDetailsEntity, Integer> {
}
