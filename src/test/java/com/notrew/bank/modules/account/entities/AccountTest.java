package com.notrew.bank.modules.account.entities;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void ShouldBeCreatePhysicalAccountCorrectly() {
        final var name = "werton";
        final var number = "0000000000";
        final var cnpj = "121.111.111-11";

        final var accountPhysical = new Physical(name, number, cnpj);

        Assertions.assertNotNull(accountPhysical);
        Assertions.assertEquals(accountPhysical.getName(), name);
        Assertions.assertEquals(accountPhysical.getCpf(), cnpj);
        Assertions.assertEquals(accountPhysical.getNumber(), number);
        Assertions.assertNotNull(accountPhysical.getUUID());
        Assertions.assertNotNull(accountPhysical.getCreatedAt());


    }

    @Test
    public void ShouldBeCreateLegalAccountCorrectly() {
        final var name = "werton";
        final var number = "0000000000";
        final var cnpj = "23.742.324/0001-09";

        final var accountPhysical = new Physical(name, number, cnpj);

        Assertions.assertNotNull(accountPhysical);
        Assertions.assertEquals(accountPhysical.getName(), name);
        Assertions.assertEquals(accountPhysical.getCpf(), cnpj);
        Assertions.assertEquals(accountPhysical.getNumber(), number);
        Assertions.assertNotNull(accountPhysical.getUUID());
        Assertions.assertNotNull(accountPhysical.getCreatedAt());


    }
}
