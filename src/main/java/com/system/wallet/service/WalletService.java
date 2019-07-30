package com.system.wallet.service;


import com.system.user.util.UserException;
import com.system.wallet.dto.WalletDto;
import com.system.wallet.model.WalletData;
import com.system.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Component
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public WalletData add(WalletDto walletDto){
        WalletData walletData =toEntity(walletDto);
        walletRepository.save(walletData);
        return walletData;
    }

   

    public WalletDto getWalletById(Integer id){
        Optional<WalletDto> optionalUserData = Optional.ofNullable(toDto(walletRepository.findOne(id)));
        return optionalUserData.orElseThrow(() -> new UserException("Wallet not find with id " + id));
    }

    public WalletDto getWalletByUserId(Integer userId){
        Optional<WalletDto> optionalUserDto = Optional.ofNullable(toDto(walletRepository.findByUserId(userId)));
        return optionalUserDto.orElseThrow(() -> new UserException("User  wallet not found "));
    }

    public Boolean walletExitsById(Integer id){
        return walletRepository.exists(id);
    }
    public Boolean walletExistsbyUserId(Integer userId){
        return walletRepository.existsByUserId(userId);
    }

    private WalletData toEntity(@Valid  WalletDto walletDto) {
        WalletData entity = new WalletData();
        if(walletDto.getId()!=null){
            entity.setId(walletDto.getId());
        }
        entity.setWalletBalance(walletDto.getWalletBalance());
        entity.setUserId(walletDto.getUserId());

        return entity;
    }

    private WalletDto toDto(@Valid  WalletData walletData) {
        WalletDto entity = new WalletDto();
        entity.setId(walletData.getId());
        entity.setUserId(walletData.getUserId());
        entity.setWalletBalance(walletData.getWalletBalance());

        return entity;
    }


}
