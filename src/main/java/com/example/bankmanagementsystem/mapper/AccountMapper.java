package com.example.bankmanagementsystem.mapper;

import com.example.bankmanagementsystem.dtos.AccountDto;
import com.example.bankmanagementsystem.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto)
    {
        Account account=new Account(

                accountDto.getId(),
                accountDto.getAccountNumber(),
                accountDto.getBalance()
        );

        return account;
    }

    public static AccountDto mapToAccountDto(Account account)
    {
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccountNumber(),
                account.getBalance()
        );

        return accountDto;

    }


}
