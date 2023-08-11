package com.notrew.bank.modules.account.entities;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {


    @Test
    public void ShouldBeCreatePhysicalAccountCorrectly() {
        final var name = "werton";
        final var cnpj = "121.111.111-11";

        final var accountPhysical = new Physical(name, cnpj);


        Assertions.assertNotNull(accountPhysical);
        Assertions.assertEquals(accountPhysical.getName(), name);
        Assertions.assertEquals(accountPhysical.getCpf(), cnpj);
        Assertions.assertNotNull(accountPhysical.getNumber());
        Assertions.assertNotNull(accountPhysical.getUUID());
        Assertions.assertNotNull(accountPhysical.getCreatedAt());
        Assertions.assertEquals(accountPhysical.getBalance(), 0);


    }

    @Test
    public void ShouldBeCreateLegalAccountCorrectly() {
        final var name = "werton";
        final var cnpj = "23.742.324/0001-09";

        final var accountLegal = new Legal(name, cnpj);

        Assertions.assertNotNull(accountLegal);
        Assertions.assertEquals(accountLegal.getName(), name);
        Assertions.assertEquals(accountLegal.getCnpj(), cnpj);
        Assertions.assertNotNull(accountLegal.getNumber());
        Assertions.assertNotNull(accountLegal.getUUID());
        Assertions.assertNotNull(accountLegal.getCreatedAt());
        Assertions.assertEquals(accountLegal.getBalance(), 0);


    }

    @Test
    public void ShouldBeDepositInLegalAccountCorrectly() {
        final var name = "werton";
        final var cnpj = "23.742.324/0001-09";

        final var accountLegal = new Legal(name, cnpj);

        accountLegal.deposit(10);
        Assertions.assertEquals(accountLegal.getBalance(), 10);
    }

    @Test
    public void ShouldBeWithdrawInLegalAccountCorrectly() {
        final var name = "werton";
        final var cnpj = "23.742.324/0001-09";

        final var accountLegal = new Legal(name, cnpj);

        accountLegal.deposit(10);
        accountLegal.withDraw(5);
        Assertions.assertEquals(accountLegal.getBalance(), 5);
    }


}
