package com.notrew.bank.modules.account.entities;


public class Legal extends Account {

    private final String cnpj;


    public Legal(String name, String number, String cnpj) {
        super(name, number);
        this.cnpj = cnpj;
    }
}
