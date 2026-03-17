package com.capgi.bank.config;

import com.capgi.bank.entity.Account;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;

public class CustomMapper {
//    public static AccountResponseDto mapAccountToResponseTo(Account account, AccountResponseDto accountResponseDto) {
//        account.setAccountHolderName(account.getAccountHolderName());
//        account.setAccountType(account.getAccountType());
//        account.setAccountSecureKey(account.getAccountSecureKey());
//        account.setHolderEmail(account.getHolderEmail());
//        account.setBalance(account.getBalance());
//    }

    public static Account mapAccountDtoToAccount(AccountDto accountDto, Account account) {
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setAccountType(accountDto.getAccountType());
        account.setAccountSecureKey(accountDto.getAccountSecureKey());
        account.setHolderEmail(accountDto.getHolderEmail());
        account.setBalance(accountDto.getBalance());

        return account;
    }
}
