package com.system.wallet.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "wallet_data")
public class WalletData implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "wallet_balance")
    private Integer walletBalance;

    @Column(name = "user_id", unique = true)
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public WalletData() {
    }

    public WalletData(Integer walletBalance) {
        this.walletBalance = walletBalance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Integer walletBalance) {
        this.walletBalance = walletBalance;
    }


}

