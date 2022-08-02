package com.example.bookingservice.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class BookingInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private Integer id;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String aadharNumber;
    private String roomNumbers;
    @NonNull
    private Integer roomPrice;
    private Integer transactionId;
    private LocalDateTime bookedOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(LocalDateTime bookedOn) {
        this.bookedOn = bookedOn;
    }
}
