package com.notrew.bank.modules.account.usecases;

import com.notrew.bank.modules.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DepositUseCase {
    private final AccountRepository accountRepository;

    @Autowired
    public DepositUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void call(String id, double amount) {
        final var account = accountRepository.get(id);
        if (account.isPresent()) {
            accountRepository.deposit(id, amount);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Account Not Found");
        }
    }
}
