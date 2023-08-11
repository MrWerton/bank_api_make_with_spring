package com.notrew.bank.modules.account.usecases;

import com.notrew.bank.modules.account.entities.Account;
import com.notrew.bank.modules.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAccountUseCase {
    private final AccountRepository accountRepository;

    @Autowired
    public GetAllAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> call() {
        return accountRepository.findAll();
    }
}
