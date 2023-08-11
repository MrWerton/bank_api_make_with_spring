package com.notrew.bank.modules.account.usecases;

import com.notrew.bank.modules.account.entities.Account;
import com.notrew.bank.modules.account.entities.Physical;
import com.notrew.bank.modules.account.repositories.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GetAllAccountUseCaseTest {

    @Test
    public void shouldCreateAccountCorrectly() {
        final AccountRepository accountRepositoryMock = mock(AccountRepository.class);
        final var sut = new GetAllAccountUseCase(accountRepositoryMock);
        final Account account = new Physical("romero", "100.000.000-00");

        final List<Account> accounts = new ArrayList<>() {{
            add(account);
        }};
        when(accountRepositoryMock.findAll()).thenReturn(accounts);
        final var result = sut.call();
        verify(accountRepositoryMock).findAll();
        Assertions.assertEquals(result, accounts);
    }
}
