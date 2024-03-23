package com.example.bankmanagementsystem.dtos;


import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor

public class AccountDto {
    private Long id;
    private String accountNumber;
    private double balance;

    public AccountDto(Long id, String accountNumber, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
