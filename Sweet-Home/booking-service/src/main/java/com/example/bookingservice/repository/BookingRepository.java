package com.example.bookingservice.repository;

import com.example.bookingservice.dto.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingInfoEntity, Integer> {

}
