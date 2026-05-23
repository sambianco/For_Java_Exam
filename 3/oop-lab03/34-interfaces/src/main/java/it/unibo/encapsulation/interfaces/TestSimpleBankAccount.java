package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
        AccountHolder andreaRossi = new AccountHolder("Andrea", "Rossi", 1);

        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
        AccountHolder alexBianchi = new AccountHolder("Alex", "Bianchi", 2);

        // 3) Creare i due SimpleBankAccount corrispondenti
        SimpleBankAccount andreaRossiAccount = new SimpleBankAccount(andreaRossi.getUserID(), 1000);
        SimpleBankAccount alexBianchiAccount = new SimpleBankAccount(alexBianchi.getUserID(), 2000);

        // 4) Effettuare una serie di depositi e prelievi
        andreaRossiAccount.deposit(andreaRossi.getUserID(), 500);
        andreaRossiAccount.withdraw(andreaRossi.getUserID(), 200);

        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */
        System.out.println("Andrea Rossi - Balance: " + andreaRossiAccount.getBalance());
        System.out.println("Alex Bianchi - Balance: " + alexBianchiAccount.getBalance());

        // 6) Provare a prelevare fornendo un id utente sbagliato
        andreaRossiAccount.withdraw(999, 100); // id utente sbagliato

        // 7) Controllare nuovamente l'ammontare
        System.out.println("Andrea Rossi - Balance: " + andreaRossiAccount.getBalance());
    }
}
