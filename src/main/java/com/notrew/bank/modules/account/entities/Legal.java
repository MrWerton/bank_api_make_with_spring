package com.notrew.bank.modules.account.entities;


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

    }

    @Override
    public void withDraw(double amount) {

    }
}
