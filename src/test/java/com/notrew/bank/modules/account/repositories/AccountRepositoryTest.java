package com.notrew.bank.modules.account.repositories;

import com.notrew.bank.modules.account.entities.Physical;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountRepositoryTest {
    @Test
    public void shouldDoWithDrawInCurrentAccount() {
        final var sut = new AccountRepositoryImp();
        final var legalAccount = new Physical("diego", "00000000");

        sut.create(legalAccount);


        sut.deposit(legalAccount.getUUID(), 10);

        final var currentAccount = sut.get(legalAccount.getUUID());


        Assertions.assertNotNull(currentAccount);
        Assertions.assertEquals(currentAccount.orElseThrow().getName(), "diego");
        Assertions.assertEquals(currentAccount.orElseThrow().getBalance(), 10);

    }

    @Test
    public void shouldDoDepositInCurrentAccount() {
        final var sut = new AccountRepositoryImp();
        final var legalAccount = new Physical("diego", "00000000");

        sut.create(legalAccount);


        sut.deposit(legalAccount.getUUID(), 10);
        sut.withDraw(legalAccount.getUUID(), 5);

        final var currentAccount = sut.get(legalAccount.getUUID());


        Assertions.assertNotNull(currentAccount);
        Assertions.assertEquals(currentAccount.orElseThrow().getName(), "diego");
        Assertions.assertEquals(currentAccount.orElseThrow().getBalance(), 5);

    }


}
