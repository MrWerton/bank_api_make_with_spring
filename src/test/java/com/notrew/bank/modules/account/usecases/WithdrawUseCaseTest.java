package com.notrew.bank.modules.account.usecases;

import com.notrew.bank.modules.account.entities.Account;
import com.notrew.bank.modules.account.entities.Physical;
import com.notrew.bank.modules.account.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class WithdrawUseCaseTest {

    @Test
    public void shouldWithdrawCorrectly() {
        final AccountRepository accountRepositoryMock = mock(AccountRepository.class);
        final var sut = new WithDrawUseCase(accountRepositoryMock);
        final Account account = new Physical("romero", "100.000.000-00");
        when(accountRepositoryMock.get(account.getUUID())).thenReturn(Optional.of(account));
        

        sut.call(account.getUUID(), 1);
        verify(accountRepositoryMock).withDraw(account.getUUID(), 1);
    }
}
