package com.notrew.bank.modules.account.entities;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Legal extends Account {

    private final String cnpj;

    public Legal(String name, String cnpj) {
        super(name);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
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
