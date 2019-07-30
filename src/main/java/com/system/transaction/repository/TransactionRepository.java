package com.system.transaction.repository;

import com.system.transaction.model.TransactionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionData, Integer> {

    List<TransactionData> findAllBySenderId(Integer senderId);
    List<TransactionData> findAllByReceiverId(Integer receiverId);

}