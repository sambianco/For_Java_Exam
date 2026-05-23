package it.unibo.encapsulation.interfaces;

public class StrictBankAccount implements BankAccount {

    private final int id;
    private double balance;
    private int transactions;
    static double ATM_TRANSACTION_FEE = 2;

    StrictBankAccount(final int id, final double balance){
        this.id = id;
        this.balance = balance;
        this.transactions = 0;
    }

    @Override
    public void withdraw(int id, double amount) {
        if (this.id == id && this.balance >= amount) {
            this.balance -= amount;
            this.transactions++;
        }
    }

    @Override
    public void deposit(int id, double amount) {
        if (this.id == id) {
            balance += amount;
            this.transactions++;
        }
    }

    @Override
    public void depositFromATM(int id, double amount) {
        if (this.id == id) {
            balance += amount - ATM_TRANSACTION_FEE;
            this.transactions++;
        }
    }

    @Override
    public void withdrawFromATM(int id, double amount) {
        if (this.id == id && this.balance >= (amount + ATM_TRANSACTION_FEE)) {
            balance -= amount - ATM_TRANSACTION_FEE;
            this.transactions++;
        }
    }

    @Override
    public void chargeManagementFees(int id) {
        if (this.id == id) {
            this.balance -= 5.0 + this.transactions*0.1;
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public int getTransactionsCount() {
        return this.transactions;
    }

    /*
     * Implementare la classe StrictBankAccount che implementa l'interfaccia
     * BankAccount. La classe deve essere progettata in modo da non permettere
     * operazioni di deposito o prelievo se l'id utente fornito non corrisponde a
     * quello del possessore del conto.
     */

}
