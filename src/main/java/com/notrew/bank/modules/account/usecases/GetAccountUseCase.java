package com.notrew.bank.modules.account.usecases;

import com.notrew.bank.modules.account.entities.Account;
import com.notrew.bank.modules.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetAccountUseCase {
    private final AccountRepository accountRepository;

    @Autowired
    public GetAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account call(String id) {
        final var account = accountRepository.get(id);
        if (account.isPresent()) {
            return account.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Account Not Found");
        }
    }
}
