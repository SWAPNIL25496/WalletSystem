package com.system.wallet.repository;

import com.system.wallet.model.WalletData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletData, Integer> {
    boolean existsByUserId(Integer userId);

    WalletData findByUserId(Integer userId);

}
