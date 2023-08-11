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


    }

    @Test
    public void ShouldBeCreateLegalAccountCorrectly() {
        final var name = "werton";
        final var cnpj = "23.742.324/0001-09";

        final var accountPhysical = new Legal(name, cnpj);

        Assertions.assertNotNull(accountPhysical);
        Assertions.assertEquals(accountPhysical.getName(), name);
        Assertions.assertEquals(accountPhysical.getCnpj(), cnpj);
        Assertions.assertNotNull(accountPhysical.getNumber());
        Assertions.assertNotNull(accountPhysical.getUUID());
        Assertions.assertNotNull(accountPhysical.getCreatedAt());


    }
}
