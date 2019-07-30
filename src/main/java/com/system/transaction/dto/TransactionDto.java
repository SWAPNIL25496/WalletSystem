package com.system.transaction.dto;

import com.system.transaction.model.TransactionData;

import java.time.LocalDateTime;
import java.util.Comparator;

public class TransactionDto  implements Comparator<TransactionDto> {

    private Integer id;

    private Integer senderId;

    private  Integer receiverId;

    private Integer amount;

    private String status;

    private LocalDateTime transactionTime;

    public TransactionDto() {
    }

    public TransactionDto(Integer senderId, Integer receiverId, Integer amount, String status, LocalDateTime transactionTime) {

        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.status = status;
        this.transactionTime = transactionTime;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compare(TransactionDto t1, TransactionDto t2) {
        return t1.getTransactionTime().compareTo(t2.getTransactionTime());

    }
}
