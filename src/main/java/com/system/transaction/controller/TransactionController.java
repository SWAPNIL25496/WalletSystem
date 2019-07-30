package com.system.transaction.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.system.transaction.dto.TransactionDto;
import com.system.transaction.model.TransactionData;
import com.system.transaction.repository.TransactionRepository;
import com.system.transaction.service.TransactionService;
import com.system.user.dto.UserDto;
import com.system.user.service.UserService;
import com.system.wallet.dto.WalletDto;
import com.system.wallet.model.WalletData;
import com.system.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class TransactionController {
    @Autowired
    UserService userService;

    @Autowired
    WalletService walletService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionRepository transactionRepository;



    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/transaction")
    public TransactionDto sendAndReceiveMoney(@RequestBody ObjectNode objectNode){
        String  receiverPhoneNumber = objectNode.get("receiverPhoneNumber").asText();
        Integer senderId = objectNode.get("senderId").asInt();
        Integer transactionType = objectNode.get("transactionType").asInt();
        Integer amount = objectNode.get("amount").asInt();

        TransactionDto transactionDto = new TransactionDto();

        if(userService.userExitsById(senderId)){
            transactionDto.setSenderId(senderId);
            transactionDto.setAmount(amount);

            WalletDto senderWallet ;

            if(walletService.walletExistsbyUserId(senderId)){
                senderWallet =walletService.getWalletByUserId(senderId);
                Integer senderBalance = senderWallet.getWalletBalance();

                if(userService.userExitsByPhoneNumber(receiverPhoneNumber)){
                    UserDto receiverData = userService.getUserByPhoneNumber(receiverPhoneNumber);
                    transactionDto.setReceiverId(receiverData.getId());
                    transactionDto.setTransactionTime(LocalDateTime.now());

                    if(amount<=senderBalance) {
                        if (walletService.walletExistsbyUserId(receiverData.getId())) {
                            WalletDto receiverWallet = walletService.getWalletByUserId(receiverData.getId());
                            Integer recieverBalance = receiverWallet.getWalletBalance();
                            senderBalance = senderBalance - amount;
                            recieverBalance = recieverBalance + amount;
                            senderWallet.setWalletBalance(senderBalance);
                            receiverWallet.setWalletBalance(recieverBalance);
                            WalletData walletData = walletService.add(senderWallet);
                            walletData=walletService.add(receiverWallet);
                            transactionDto.setStatus("Pass");
                        } else {
                            WalletDto walletDto = new WalletDto();
                            walletDto.setWalletBalance(amount);
                            walletDto.setUserId(receiverData.getId());
                            WalletData walletData= walletService.add(walletDto);
                            transactionDto.setStatus("Pass");

                        }
                    }else {
                        transactionDto.setStatus("Fail");
                    }



                }
                else
                    throw new NullPointerException("Receiver does not exists");



            }else
                throw new NullPointerException("wallet do dont exits");


        }
        else
            throw new NullPointerException("sender do not exits");

        return transactionService.add(transactionDto);

    }

    @GetMapping("/passbook/{id}")
    public List<TransactionData> getPassbook(@PathVariable("id") Integer userId){
        List<TransactionData> passbookTransactions = new ArrayList<>();
        passbookTransactions.addAll(transactionRepository.findAllByReceiverId(userId));
        passbookTransactions.addAll(transactionRepository.findAllBySenderId(userId));
        Collections.sort(passbookTransactions,new TransactionData());
        return passbookTransactions;
    }
}
