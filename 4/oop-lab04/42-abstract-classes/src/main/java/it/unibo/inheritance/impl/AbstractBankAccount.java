package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;
import it.unibo.inheritance.api.BankAccount;

public abstract class AbstractBankAccount implements BankAccount {
    
    private static final double ATM_TRANSACTION_FEE = 1;
    protected static final double MANAGEMENT_FEE = 5;
    private final AccountHolder holder;
    private double balance;
    private int transactions;

    protected AbstractBankAccount(final AccountHolder accountHolder, final double balance) {
        this.holder = accountHolder;
        this.balance = balance;
        this.transactions = 0;
    }

    @Override
    public void chargeManagementFees(final int id) {
        if (checkUser(id)) {
            this.balance -= this.computeFee(); // Usa il metodo astratto per calcolare le spese
            resetTransactions();
        }
    }

    @Override
    public void deposit(final int id, final double amount){
        this.transactionOp(id, amount);
    }

    @Override
    public void depositFromATM(final int id, final double amount){
        this.deposit(id, amount - ATM_TRANSACTION_FEE);
    }

    @Override
    public AccountHolder getAccountHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public int getTransactionsCount() {
        return this.transactions;
    }

    @Override
    public void withdraw(final int id, final double amount) {
        // Controlla prima l'utente e poi se il prelievo è permesso
        if (checkUser(id) && isWithDrawAllowed(amount)) {
            this.transactionOp(id, -amount);
        }
    }

    @Override
    public void withdrawFromATM(final int id, final double amount) {
        final double totalAmount = amount + ATM_TRANSACTION_FEE;
        // Controlla l'utente e se il prelievo COMPRESA la tassa è permesso
        if (checkUser(id) && isWithDrawAllowed(totalAmount)) {
            this.transactionOp(id, -totalAmount);
        }
    }

    protected boolean checkUser(final int id) {
        return this.holder.getUserID() == id;
    }

    protected void transactionOp(final int id, final double amount) {
        if (checkUser(id)) {
            this.balance += amount;
            this.incrementTransactions();
        }
    }

    protected void incrementTransactions() {
        this.transactions++;
    }

     protected void resetTransactions() {
        this.transactions = 0;
    }

    protected abstract boolean isWithDrawAllowed(double amount);
    protected abstract double computeFee();
}
