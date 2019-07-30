package com.system.wallet.controller;



import com.system.user.dto.UserDto;
import com.system.user.service.UserService;
import com.system.wallet.dto.WalletDto;
import com.system.wallet.model.WalletData;
import com.system.wallet.service.WalletService;
import com.system.wallet.util.WalletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class WalletController {
    @Autowired
    WalletService walletService;

    @Autowired
    UserService userService;

    @PostMapping("/wallet")
    public WalletData createNewUser(@Valid @RequestBody WalletDto walletDto) {


        if (walletService.walletExistsbyUserId(walletDto.getUserId())) {

            throw new WalletException("user found with wallet");

        }
        if (!(userService.userExitsById(walletDto.getUserId()))) {
            throw new WalletException("user do not exists");

        }
        return walletService.add(walletDto);
    }


    @GetMapping("/wallet/{id}")
    public WalletDto getWallet(@PathVariable("id") Integer Id) {
        return walletService.getWalletById(Id);

    }

    @PutMapping("/wallet")
    public WalletDto editOneWallet(
            @RequestBody WalletDto walletDto
    ) {
        WalletDto walletDto1 = walletService.getWalletById(walletDto.getId());

        if (walletDto.getWalletBalance() != null){
            Integer newBalance=walletDto.getWalletBalance() + walletDto1.getWalletBalance();
            walletDto1.setWalletBalance(newBalance);
        }
        if (walletDto.getUserId() != null){

            throw new WalletException("can't change user of wallet");
        }
        walletService.add(walletDto1);

        return walletDto1;


    }


}

