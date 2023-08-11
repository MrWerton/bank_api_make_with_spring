package com.notrew.bank.modules.account.repositories;

import com.notrew.bank.modules.account.entities.Account;
import com.notrew.bank.modules.account.entities.Legal;
import com.notrew.bank.modules.account.entities.Physical;
import com.notrew.bank.shared.database.BankSingleton;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImp implements AccountRepository {

    private final BankSingleton db = BankSingleton.getInstance();

    @Override
    public void create(Account customer) {
        db.accounts.add(customer);
    }

    @Override
    public void deposit(String id, double amount) {
        this.db.accounts.forEach(item -> {
            if (item.getUUID().equals(id)) {
                item.getBalance();
                item.deposit(amount);
            }
        });
    }

    @Override
    public void withDraw(String id, double amount) {
        final var currentAccount = get(id);
        currentAccount.ifPresent(value -> value.withDraw(amount));
    }

    @Override
    public Optional<Account> get(String id) {
        return db.accounts.stream().filter(customer -> customer.getUUID().equals(id)).findFirst();
    }

    @Override
    public boolean checkIfAlreadyExists(String name) {
        return db.accounts.stream()
                .anyMatch(account -> account instanceof Physical && account.getName().equals(name))
                || db.accounts.stream()
                .anyMatch(account -> account instanceof Legal && account.getName().equals(name));
    }

    @Override
    public List<Account> findAll() {
        return db.accounts;
    }

    @Override
    public void delete(String id) {
        db.accounts.removeIf(account -> account.getUUID().equals(id));
    }


}
