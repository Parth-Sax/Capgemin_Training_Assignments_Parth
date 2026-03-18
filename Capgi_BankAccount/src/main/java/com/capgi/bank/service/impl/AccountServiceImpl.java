package com.capgi.bank.service.impl;

import com.capgi.bank.config.CustomMapper;
import com.capgi.bank.entity.Account;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;
import com.capgi.bank.exception.AccountNotFoundException;
import com.capgi.bank.repository.AccountRepository;
import com.capgi.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    @Override
    public void createAccount(AccountDto accountDto) {
//        Account account = new Account();
//        account.setAccountHolderName(accountDto.getAccountHolderName());
//        account.setAccountType(accountDto.getAccountType());
//        account.setAccountSecureKey(accountDto.getAccountSecureKey());
//        account.setHolderEmail(accountDto.getHolderEmail());
//        account.setBalance(accountDto.getBalance());

        Account account = CustomMapper.mapAccountDtoToAccount(accountDto, new Account());
        accountRepository.save(account);
    }

    @Override
    public AccountResponseDto getAccountById(Integer id) {
        Optional<Account> account = accountRepository.findById(id);
//        Account account = accountRepository.getReferenceById(id);
        AccountResponseDto accountDto = modelMapper.map(account, AccountResponseDto.class);
        return accountDto;
    }

    @Override
    public List<AccountResponseDto> findAll() {
        List<Account> accountList = accountRepository.findAll();

        List<AccountResponseDto> accountResponseDtoList =
                accountList.stream()
                        .map(account -> modelMapper.map(account, AccountResponseDto.class))
                        .toList();

        return accountResponseDtoList;
    }

    @Override
    public AccountResponseDto exceptionalHandlingGetAccountById(Integer id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException("Account not found " + id));
//        Account account = accountRepository.getReferenceById(id);
        AccountResponseDto accountDto = modelMapper.map(account, AccountResponseDto.class);
        return accountDto;
    }

    @Override
    public AccountResponseDto updateAccount(Integer id, AccountDto accountDto) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RunTimeException("Account not found"));

        // map DTO -> entity
        modelMapper.map(accountDto, account);

        Account updatedAccount = accountRepository.save(account);

        return modelMapper.map();
    }
}
