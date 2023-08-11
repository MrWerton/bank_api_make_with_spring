package com.notrew.bank.modules.account.usecases;

import com.notrew.bank.modules.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteAccountUseCase {
    private final AccountRepository accountRepository;

    @Autowired
    public DeleteAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void call(String id) {
        final var accountAlreadyExists = accountRepository.get(id);
        if (accountAlreadyExists.isPresent()) {
            accountRepository.delete(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Account not exists");
        }
    }
}
