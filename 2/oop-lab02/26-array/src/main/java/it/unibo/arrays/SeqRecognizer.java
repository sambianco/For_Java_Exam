package it.unibo.arrays;

/* La classe `SeqRecognizer` implementa un riconoscitore di varie sequenze di caratteri.
Si analizzi il primo esempio già implementato `boolean checkSeq1(int[] array)` che riconosce la sequenza {1}{2|3},
ossia, una qualunque sequenza (anche vuota) di 1 seguita da una qualunque sequenza (anche vuota) di 2 o 3.
Strategia risolutiva in linguaggio naturale:
    1. Finché trovo una sequenza di uno, vado avanti nell’array
    2. Finché trovo dei due o dei tre, vado avanti nell’array
    3. Verifico di essere arrivato in fondo
2. Si scriva il metodo `static boolean checkSeq2(int[] array)`,
che riconosce la sequenza 1{2}3, ossia una occorrenza di 1, 
seguita da una qualunque sequenza (anche vuota) di 2, seguita da un 3.
3. Si scriva il metodo `static boolean checkSeq3(int[] array)`,
che riconosce la sequenza 1{2}3{4}[5],
ossia una occorrenza di 1 , seguita da una qualunque sequenza (anche vuota) di 2, seguita da un 3,
seguita da una qualunque sequenza (anche vuota) di 4,
seguita opzionalmente da un 5
4. Si scriva il metodo `static boolean checkSeq4(int[] array)`,
che riconosce la sequenza [2|3]{4}5 */

class SeqRecognizer {

    /*
     * Recognizes: {1}{2|3}.
     */
    static boolean checkSeq1(final int[] array) {
        int i = 0;
        for (; i < array.length && array[i] == 1; i++);
        for (; i < array.length && (array[i] == 2 || array[i] == 3); i++);
        return i == array.length;
    }

    /*
     * Recognizes: 1{2}3. Si scriva il metodo `static boolean checkSeq2(int[] array)`,
che riconosce la sequenza 1{2}3, ossia una occorrenza di 1, 
seguita da una qualunque sequenza (anche vuota) di 2, seguita da un 3.
     */
    static boolean checkSeq2(final int[] array) {
        int i = 0;
        if (i < array.length && array[i] == 1) {
            i++;
            for (; i < array.length && array[i] == 2; i++);
            if (i < array.length && array[i] == 3) {
                i++;
                return i == array.length;
            }
        }
        return false;
        
    }

    /*
     * Recognizes: 1{2}3{4}[5].
     */
    static boolean checkSeq3(final int[] array) {
        int i = 0;
        if (i < array.length && array[i] == 1) {
            i++;
            for (; i < array.length && array[i] == 2; i++);
            if (i < array.length && array[i] == 3) {
                i++;
                for (; i < array.length && array[i] == 4; i++);
                if (i < array.length && array[i] == 5) {
                    i++;
                }
                return i == array.length;
            }
        }
        return false;
    }

    /*
     * Recognizes: [2|3]{4}5.
     */
    static boolean checkSeq4(final int[] array) {
        int i = 0;
        for (; i < array.length && (array[i] == 2 || array[i] == 3); i++);
        for (; i < array.length && array[i] == 4; i++);
        if (i < array.length && array[i] == 5) {
            i++;
            return i == array.length;
        }
        return false;
    }

    /** Testing methods **/

    /* Utility method for testing checkSeq1 method */
    static boolean testCheckSeq1() {
        return checkSeq1(new int[] { })
            && checkSeq1(new int[] { 1, 1 })
            && checkSeq1(new int[] { 1, 1, 1, 2 })
            && checkSeq1(new int[] { 1, 1, 1, 2, 3, 2, 3 })
            && !checkSeq1(new int[] { 1, 1, 1, 2, 3, 1, 3 })
            && !checkSeq1(new int[] { 1, 1, 1, 2, 3, 1, 3 })
            && !checkSeq1(new int[] { 3, 2, 1, 1 });
    }

    /* Utility method for testing checkSeq2 method */
    static boolean testCheckSeq2() {
        return checkSeq2(new int[] { 1, 3 })
                && checkSeq2(new int[] { 1, 2, 3 })
                && checkSeq2(new int[] { 1, 2, 2, 2, 2, 2, 2, 3 })
                && !checkSeq2(new int[] { })
                && !checkSeq2(new int[] { 1, 2, 2 })
                && !checkSeq2(new int[] { 2, 2, 2, 2, 3 });
    }

    /* Utility method for testing checkSeq3 method */
    static boolean testCheckSeq3() {
        return checkSeq3(new int[] { 1, 3 })
                && checkSeq3(new int[] { 1, 3, 5 })
                && checkSeq3(new int[] { 1, 2, 2, 2, 2, 2, 2, 3 })
                && checkSeq3(new int[] { 1, 2, 3, 4, 5 })
                && checkSeq3(new int[] { 1, 2, 2, 3, 4, 4, 4, 5 })
                && checkSeq3(new int[] { 1, 2, 2, 2, 3 })
                && !checkSeq3(new int[] { })
                && !checkSeq3(new int[] { 1, 2, 2, 2 })
                && !checkSeq3(new int[] { 2, 2, 3, 4, 4, 4 })
                && !checkSeq3(new int[] { 1, 2, 2, 3, 4, 4, 4, 5, 6 });
    }

    static boolean testCheckSeq4() {
        return checkSeq4(new int[] { 2, 5 })
            && checkSeq4(new int[] { 5 })
            && checkSeq4(new int[] { 3, 5 })
            && checkSeq4(new int[] { 4, 5 })
            && checkSeq4(new int[] { 2, 4, 4, 4, 4, 4, 5 })
            && checkSeq4(new int[] { 3, 4, 5 })
            && checkSeq4(new int[] { 3, 4, 4, 4, 4, 4, 5 })
            && checkSeq4(new int[] { 4, 4, 4, 4, 4, 5 })
            && !checkSeq4(new int[] { })
            && !checkSeq4(new int[] { 2 })
            && !checkSeq4(new int[] { 3 })
            && !checkSeq4(new int[] { 3, 4 })
            && !checkSeq4(new int[] { 2, 4 })
            && !checkSeq4(new int[] { 4, 4, 4 });
    }

    public static void main(final String[] args) {
        System.out.println("testCheckSeq1: " + testCheckSeq1());
        System.out.println("testCheckSeq2: " + testCheckSeq2());
        System.out.println("testCheckSeq3: " + testCheckSeq3());
        System.out.println("testCheckSeq4: " + testCheckSeq4());
    }
}
