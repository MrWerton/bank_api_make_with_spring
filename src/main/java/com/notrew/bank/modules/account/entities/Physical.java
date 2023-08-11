package com.notrew.bank.modules.account.entities;


public class Physical extends Account {
    private final String cpf;

    public Physical(String name, String number, String cpf) {
        super(name, number);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
