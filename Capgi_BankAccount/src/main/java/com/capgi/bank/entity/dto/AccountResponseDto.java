package com.capgi.bank.entity.dto;

import lombok.Data;

@Data
public class AccountResponseDto {

    private String accountHolderName;
    private Integer accountId;
    private Long balance;
    private AccountType accountType;
}
