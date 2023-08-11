package com.notrew.bank.shared.utils;

import java.util.Random;

public class AccountNumberGenerator {
    private static final int NUM_DIGITS = 10;

    public static String generate() {
        StringBuilder accountNumber = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < NUM_DIGITS; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }


}
