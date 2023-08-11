package com.notrew.bank.modules.account.entities;

import com.notrew.bank.shared.utils.AccountNumberGenerator;
import com.notrew.bank.shared.utils.UUIDGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

interface Actions {
    void deposit(double amount);

    void withDraw(double amount);
}

public class Account implements Actions {

    private final String UUID;
    private final String name;
    private final String number;
    private final Instant createdAt;
    protected double balance;

    protected Account(String name) {
        this.balance = 0;
        UUID = UUIDGenerator.generate();
        this.name = name;
        this.number = AccountNumberGenerator.generate();
        this.createdAt = Instant.now();
    }

    public double getBalance() {
        return balance;
    }

    public String getUUID() {
        return UUID;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withDraw(double amount) {
        if (getBalance() > amount) {
            balance -= amount;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance is insufficient");
        }

    }


}
