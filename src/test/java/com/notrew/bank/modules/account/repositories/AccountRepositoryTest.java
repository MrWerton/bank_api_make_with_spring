package com.notrew.bank.modules.account.repositories;

import com.notrew.bank.modules.account.entities.Legal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountRepositoryTest {
    @Test
    public void shouldDoWithDrawInCurrentAccount() {
        final var sut = new AccountRepositoryImp();
        final var legalAccount = new Legal("cabaré_do_diego", "00000000");

        sut.create(legalAccount);


        sut.deposit(legalAccount.getUUID(), 10);

        final var currentAccount = sut.get(legalAccount.getUUID());


        Assertions.assertNotNull(currentAccount);
        Assertions.assertEquals(currentAccount.orElseThrow().getName(), "cabaré_do_diego");
        Assertions.assertEquals(currentAccount.orElseThrow().getBalance(), 10);

    }
}
