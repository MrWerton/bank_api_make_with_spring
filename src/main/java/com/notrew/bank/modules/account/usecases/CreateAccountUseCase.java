package com.notrew.bank.modules.account.usecases;

import com.notrew.bank.modules.account.entities.Account;
import com.notrew.bank.modules.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateAccountUseCase {
    private final AccountRepository accountRepository;

    @Autowired
    public CreateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void call(Account account) {
        final var accountAlreadyExists = accountRepository.checkIfAlreadyExists(account.getName());
        if (accountAlreadyExists) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Account already exists");
        } else {
            accountRepository.create(account);

        }
    }
}
