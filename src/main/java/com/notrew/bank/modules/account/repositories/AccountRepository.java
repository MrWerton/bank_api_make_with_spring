package com.notrew.bank.modules.account.repositories;

import com.notrew.bank.modules.account.entities.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    void create(Account account);

    void deposit(String account, double amount);

    void withDraw(String account, double amount);

    Optional<Account> get(String id);

    boolean checkIfAlreadyExists(String name);

    List<Account> findAll();

    void delete(String id);


}
