package com.system.transaction.util;

import com.system.transaction.dto.TransactionDto;
import com.system.transaction.model.TransactionData;

import javax.validation.Valid;

public class TransactionMapper {

    public static TransactionData toTransactionEntity( TransactionDto transactionDto){
        TransactionData transactionData = new TransactionData();
        transactionData.setReceiverId(transactionDto.getReceiverId());
        transactionData.setSenderId(transactionDto.getSenderId());
        transactionData.setAmount(transactionDto.getAmount());
        transactionData.setStatus(transactionDto.getStatus());
        transactionData.setTransactionTime(transactionDto.getTransactionTime());
        return transactionData;
    }


    public static TransactionDto toTransactionDto( TransactionData transactionData){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setReceiverId(transactionData.getReceiverId());
        transactionDto.setSenderId(transactionData.getSenderId());
        transactionDto.setAmount(transactionData.getAmount());
        transactionDto.setStatus(transactionData.getStatus());
        transactionDto.setTransactionTime(transactionData.getTransactionTime());
        transactionDto.setId(transactionData.getId());
        return transactionDto;
    }


}
