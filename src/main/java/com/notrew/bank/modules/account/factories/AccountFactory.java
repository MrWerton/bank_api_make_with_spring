package com.notrew.bank.modules.account.factories;

import com.notrew.bank.modules.account.dto.AccountDto;
import com.notrew.bank.modules.account.entities.Account;
import com.notrew.bank.modules.account.entities.Legal;
import com.notrew.bank.modules.account.entities.Physical;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AccountFactory {

    public static Account create(AccountDto accountDto) {
        final String type = accountDto.type().toLowerCase();
        return switch (type) {
            case "fisica" -> new Physical(accountDto.name(), accountDto.cpf());
            case "juridica" -> new Legal(accountDto.name(), accountDto.cnpj());
            default -> throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "type of account not is valid");
        };
    }
}
