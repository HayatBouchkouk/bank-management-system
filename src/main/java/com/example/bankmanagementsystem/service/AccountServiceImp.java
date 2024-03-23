package com.example.bankmanagementsystem.service;


import com.example.bankmanagementsystem.dtos.AccountDto;
import com.example.bankmanagementsystem.entity.Account;
import com.example.bankmanagementsystem.mapper.AccountMapper;
import com.example.bankmanagementsystem.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=  accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

       Account account =accountRepository
               .findById(id)
               .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + id));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account =accountRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + id));

        double total=account.getBalance()+amount;
        account.setBalance(total);

        Account savedAccount=accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account =accountRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + id));


        if (account.getBalance()< amount)
        {
            throw new RuntimeException("Insufficient amount!");
        }

        double total=account.getBalance()- amount;
        account.setBalance(total);

        Account savedAccount=accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
