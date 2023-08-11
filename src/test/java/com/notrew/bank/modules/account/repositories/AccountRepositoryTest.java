package com.notrew.bank.modules.account.repositories;

import com.notrew.bank.modules.account.entities.Legal;
import com.notrew.bank.modules.account.entities.Physical;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    public void shouldCreateAccountCorrectly() {
        final var sut = new AccountRepositoryImp();
        final var legalAccount = new Physical("diego", "00000000");

        sut.create(legalAccount);


        final var currentAccount = sut.get(legalAccount.getUUID());


        Assertions.assertNotNull(currentAccount);
        Assertions.assertEquals(currentAccount.orElseThrow(), legalAccount);

    }

    @Test
    public void shouldGetAccountCorrectly() {
        final var sut = new AccountRepositoryImp();
        final var legalAccount = new Physical("diego", "00000000");

        sut.create(legalAccount);


        final var currentAccount = sut.get(legalAccount.getUUID());


        Assertions.assertNotNull(currentAccount);
        Assertions.assertEquals(currentAccount.orElseThrow(), legalAccount);

    }

    @Test
    public void shouldGetAllAccountCorrectly() {
        final var sut = new AccountRepositoryImp();
        final var account1 = new Physical("diego", "792.637.370-29");
        final var account2 = new Legal("werton", "45.635.203/0001-92");

        final var accounts = new ArrayList<>() {{
            add(account1);
            add(account2);
        }};
        sut.create(account1);
        sut.create(account2);


        final var result = sut.findAll();


        Assertions.assertNotNull(result);
        Assertions.assertEquals(result, accounts);

    }
}
