package com.restapplication.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "wallet_data")
public class WalletData  implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "wallet_balance")
    private Integer walletBalance;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserData userData;


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

//    public UserData getUserData() {
//        return userData;
//    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}

