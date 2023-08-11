package com.notrew.bank.modules.account.entities;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Legal {
    private final String cnpj;
    private final Account properties;

    public Legal(String name, String cnpj, Account properties) {
        this.properties = properties;
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void deposit(double amount) {
        properties.balance += amount;
    }

    public void withDraw(double amount) {
        if (properties.getBalance() > amount) {
            properties.balance -= amount;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance is insufficient");
        }
    }
}
