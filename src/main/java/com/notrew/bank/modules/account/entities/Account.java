package com.notrew.bank.modules.account.entities;

import com.notrew.bank.shared.utils.AccountNumberGenerator;
import com.notrew.bank.shared.utils.UUIDGenerator;

import java.time.Instant;

public abstract class Account {

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


    public abstract void deposit(double amount);

    public abstract void withDraw(double amount);


}
