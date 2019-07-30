package com.system.transaction.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Comparator;


@Entity
@Table(name = "transaction_list")
public class TransactionData implements Serializable, Comparator<TransactionData> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer senderId;

    private  Integer receiverId;

    private Integer amount;

    private String status;

    private LocalDateTime transactionTime;


    public TransactionData() {
    }

    public TransactionData(Integer senderId, Integer recieverId, Integer amount, String status, LocalDateTime transactionTime) {
        this.senderId = senderId;
        this.receiverId = recieverId;
        this.amount = amount;
        this.status = status;
        this.transactionTime = transactionTime;
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


    @Override
    public int compare(TransactionData t1, TransactionData t2) {
        return t1.getTransactionTime().compareTo(t2.getTransactionTime());
    }
}
