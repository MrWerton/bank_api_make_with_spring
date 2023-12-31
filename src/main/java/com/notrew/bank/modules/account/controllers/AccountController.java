package com.notrew.bank.modules.account.controllers;

import com.notrew.bank.modules.account.dto.AccountDto;
import com.notrew.bank.modules.account.dto.OperationDto;
import com.notrew.bank.modules.account.factories.AccountFactory;
import com.notrew.bank.modules.account.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AccountController {
    private final GetAccountUseCase getAccountUseCase;
    private final GetAllAccountUseCase getAllAccountUseCase;
    private final CreateAccountUseCase createAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;
    private final WithDrawUseCase withDrawUseCase;
    private final DepositUseCase depositUseCase;

    @Autowired
    public AccountController(GetAccountUseCase getAccountUseCase, GetAllAccountUseCase getAllAccountUseCase, CreateAccountUseCase createAccountUseCase, DeleteAccountUseCase deleteAccountUseCase, WithDrawUseCase withDrawUseCase, DepositUseCase depositUseCase) {
        this.getAccountUseCase = getAccountUseCase;
        this.getAllAccountUseCase = getAllAccountUseCase;
        this.createAccountUseCase = createAccountUseCase;
        this.deleteAccountUseCase = deleteAccountUseCase;
        this.withDrawUseCase = withDrawUseCase;
        this.depositUseCase = depositUseCase;
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllAccount() {
        try {
            final var accounts = getAllAccountUseCase.call();
            return ResponseEntity.ok(accounts);
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }

    }

    @GetMapping("/")
    public ResponseEntity<?> getAccount(@RequestParam(name = "id") String id) {
        try {
            final var account = getAccountUseCase.call(id);
            return ResponseEntity.ok(account);
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }

    }

    @PostMapping("/")
    public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto) {
        try {
            final var account = AccountFactory.create(accountDto);
            createAccountUseCase.call(account);
            return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }


    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAccount(@RequestParam(name = "id") String id) {
        try {
            deleteAccountUseCase.call(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Account removed successfully");
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }

    }

    @PutMapping("/withdraw")
    public ResponseEntity<?> withDrawAccount(@RequestParam(name = "id") String id, @RequestBody OperationDto operationDto) {
        try {
            withDrawUseCase.call(id, operationDto.amount());
            return ResponseEntity.status(HttpStatus.CREATED).body("Account withdrawn with success");
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }

    }

    @PutMapping("/deposit")
    public ResponseEntity<?> depositAccount(@RequestParam(name = "id") String id, @RequestBody OperationDto operationDto) {
        try {
            depositUseCase.call(id, operationDto.amount());
            return ResponseEntity.status(HttpStatus.CREATED).body("Account deposited with success");
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }

    }

}
