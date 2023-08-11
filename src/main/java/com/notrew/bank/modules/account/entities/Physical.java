package com.notrew.bank.modules.account.entities;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Physical extends Account {
    private final String cpf;

    public Physical(String name, String cpf) {
        super(name);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public void deposit(double amount) {
        super.balance += amount;
    }

    @Override
    public void withDraw(double amount) {
        if (super.getBalance() > amount) {
            super.balance -= amount;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance is insufficient");
        }
    }
}
