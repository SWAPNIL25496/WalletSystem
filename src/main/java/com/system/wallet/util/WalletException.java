package com.system.wallet.util;

//@ResponseStatus(HttpStatus.OK)
public class WalletException extends RuntimeException {
    public WalletException(String message) {
        super(message);
    }
}
