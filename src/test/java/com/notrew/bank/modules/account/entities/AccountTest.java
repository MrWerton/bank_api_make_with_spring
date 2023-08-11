package com.notrew.bank.modules.account.entities;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {


    @Test
    public void ShouldBeCreatePhysicalAccountCorrectly() {
        final var name = "werton";
        final var cnpj = "121.111.111-11";

        final var account = new Account(name);
        final var accountPhysical = new Legal(cnpj, account);


        accountPhysical.deposit(10);

        Assertions.assertNotNull(accountPhysical);
        Assertions.assertEquals(accountPhysical.getProperties().balance, 10);


    }


}
