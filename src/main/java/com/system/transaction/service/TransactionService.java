package com.system.transaction.service;

import com.system.transaction.dto.TransactionDto;
import com.system.transaction.model.TransactionData;
import com.system.transaction.repository.TransactionRepository;
import com.system.transaction.util.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDto add(TransactionDto transactionDto){
        TransactionData transactionData = TransactionMapper.toTransactionEntity(transactionDto);
        transactionRepository.save(transactionData);
        return TransactionMapper.toTransactionDto(transactionData);
    }


}

