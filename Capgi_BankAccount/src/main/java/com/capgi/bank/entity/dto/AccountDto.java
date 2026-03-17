package com.capgi.bank.entity.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

//@Data
public class AccountDto {
    private Integer accountId;
    private String accountHolderName;
    private Long balance;
    private AccountType accountType;
    private String holderEmail;
    private String accountSecureKey;

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getHolderEmail() {
        return holderEmail;
    }

    public void setHolderEmail(String holderEmail) {
        this.holderEmail = holderEmail;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountSecureKey() {
        return accountSecureKey;
    }

    public void setAccountSecureKey(String accountSecureKey) {
        this.accountSecureKey = accountSecureKey;
    }
}
