package com.notrew.bank.modules.account.usecases;

import com.notrew.bank.modules.account.entities.Account;
import com.notrew.bank.modules.account.entities.Physical;
import com.notrew.bank.modules.account.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateAccountUseCaseTest {

    @Test
    public void shouldCreateAccountCorrectly() {
        final AccountRepository accountRepositoryMock = mock(AccountRepository.class);
        final var sut = new CreateAccountUseCase(accountRepositoryMock);
        final Account account = new Physical("romero", "100.000.000-00");

        sut.call(account);
        verify(accountRepositoryMock).create(account);
    }
}
