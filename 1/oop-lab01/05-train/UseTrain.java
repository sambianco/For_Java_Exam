class UseTrain {
    public static void main(String[] args) {
        /*
         * Premesse per un corretto testing della classe. Per ragioni di
         * coerenza e semplicità:
         * - I vari metodi siano sempre invocati passando dei parametri di input
         * validi e consistenti (p.e. non invocare i metodi per effettuare delle
         * prenotazioni specificando un numero di posti superiore alla capienza
         * del treno, ai posti disponibili per la classe (prima/seconda)
         * considerata, al numero di posti correntemente liberi
         *
         *
         * Testing: 1) Creare un oggetto della classe Train specificando valori
         * a piacere per i parametri
         *
         * 2) Effettuare delle prenotazioni in prima e seconda classe
         * specificando un numero di posti da prenotare consistente
         *
         * 3) A seguito di ciascuna prenotazione stampare la ratio di
         * occupazione totale e per ciascuna classe.
         *
         * 4) Cancellare tutte le prenotazioni
         *
         * 5) Prenotare nuovamente dei posti e stampare le nuove percentuali di
         * occupazione
         */
        Train t = new Train();
        t.build(100, 200);
        t.bookFirstClassSeats(50);
        t.bookSecondClassSeats(150);
        System.out.println("Total occupancy ratio: " + t.getTotalOccupancyRatio());
        System.out.println("First class occupancy ratio: " + t.getFirstClassOccupancyRatio());
        System.out.println("Second class occupancy ratio: " + t.getSecondClassOccupancyRatio());
        t.cancelAllBookings();
        t.bookFirstClassSeats(30);
        t.bookSecondClassSeats(100);
        System.out.println("Total occupancy ratio: " + t.getTotalOccupancyRatio());
        System.out.println("First class occupancy ratio: " + t.getFirstClassOccupancyRatio());
        System.out.println("Second class occupancy ratio: " + t.getSecondClassOccupancyRatio());
    }
}
