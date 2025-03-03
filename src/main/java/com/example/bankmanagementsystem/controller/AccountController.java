package com.example.bankmanagementsystem.controller;


import com.example.bankmanagementsystem.dtos.AccountDto;
import com.example.bankmanagementsystem.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
    {
       AccountDto accountDto= accountService.getAccountById(id);
       return ResponseEntity.ok(accountDto);
    }

    @PutMapping("{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String, Double> request)
    {
        Double amount=request.get("amount");

        AccountDto accountDto=accountService.deposit(id,amount);

        return ResponseEntity.ok(accountDto);

    }

    @PutMapping("{id}/withdraw")

    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String, Double> request)
    {
        Double amount=request.get("amount");

        AccountDto accountDto=accountService.withdraw(id,amount);

        return ResponseEntity.ok(accountDto);

    }



}
