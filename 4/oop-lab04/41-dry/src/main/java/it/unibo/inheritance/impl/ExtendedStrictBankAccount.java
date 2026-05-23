package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount {

    private static final double TRANSACTION_FEE = 0.1;

    public ExtendedStrictBankAccount(int id, double balance) {
        super(id, balance);
    }
    
    @Override
    public void withdraw(final int id, final double amount) {
        if (isWithdrawAllowed(amount)) {
            super.withdraw(id, -amount);
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        return super.getBalance() >= amount;
    }

    @Override
    public void chargeManagementFees(final int id) {
        if (checkUser(id)) {
            final double feeAmount = MANAGEMENT_FEE + super.getTransactionsCount() * ExtendedStrictBankAccount.TRANSACTION_FEE;
            if (isWithdrawAllowed(feeAmount)) {
                super.setBalance(super.getBalance() - feeAmount);
            }
        }
    }
}
