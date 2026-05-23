package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class RestrictedBankAccount extends AbstractBankAccount {

    private static final double TRANSACTION_FEE = 0.1;

    public RestrictedBankAccount(AccountHolder accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    protected boolean isWithDrawAllowed(double amount) {
        return this.getBalance() >= amount;
    }

    @Override
    protected double computeFee() {
        return MANAGEMENT_FEE + (this.getTransactionsCount() * TRANSACTION_FEE);
    }

}