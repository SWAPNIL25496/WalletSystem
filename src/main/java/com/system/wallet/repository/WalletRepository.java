package com.restapplication.repositories;

import com.restapplication.model.UserData;
import com.restapplication.model.WalletData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletData, Integer> {
    WalletData findByUserData(UserData userData);

}
