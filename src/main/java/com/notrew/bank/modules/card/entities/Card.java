package com.notrew.bank.modules.card.entities;

import java.sql.Timestamp;

public abstract class Card {
    private String number;
    private Timestamp expirationDate;
    private String holderName;

    public abstract void processPayment(double amount);


}
