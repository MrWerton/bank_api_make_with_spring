package com.notrew.bank.shared.database;

import com.notrew.bank.modules.account.entities.Account;

import java.util.ArrayList;
import java.util.List;

public class BankSingleton {
    private static BankSingleton instance;
     public  final List<Account> accounts;
    private BankSingleton() {
        accounts =new ArrayList<>();
    }

    public static BankSingleton getInstance() {
        if (instance == null) {
            synchronized (BankSingleton.class) {
                if (instance == null) {
                    instance = new BankSingleton();
                }
            }
        }
        return instance;
    }

}
