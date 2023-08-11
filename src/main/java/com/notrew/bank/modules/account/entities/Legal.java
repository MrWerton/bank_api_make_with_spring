package com.notrew.bank.modules.account.entities;


public class Legal {
    private final String cnpj;
    private final Account properties;

    public Legal(String cnpj, Account properties) {
        this.properties = properties;
        this.cnpj = cnpj;
    }

    public Account getProperties() {
        return properties;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void deposit(double amount) {
        properties.deposit(amount);

    }

    public void withDraw(double amount) {
        properties.withDraw(amount);

    }
}
