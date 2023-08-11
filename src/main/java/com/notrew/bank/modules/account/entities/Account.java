package com.notrew.bank.modules.account.entities;

import com.notrew.bank.shared.utils.UUIDGenerator;

import java.time.Instant;

public abstract class Account {

    private final String UUID;
    private final String name;
    private final String number;
    private final Instant createdAt;

    protected Account(String name, String number) {
        UUID = UUIDGenerator.generate();
        this.name = name;
        this.number = number;
        this.createdAt = Instant.now();
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


}
