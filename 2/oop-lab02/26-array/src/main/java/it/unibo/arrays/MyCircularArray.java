package it.unibo.arrays;

class MyCircularArray {

    int[] array;

    MyCircularArray(int size) {
        this.array = new int[size];
    }

    MyCircularArray() {
        this(10);
    }

    void add(final int elem) {
        for (int i = 0; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.array.length - 1] = elem;
    }

    void reset() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = 0;
        }
    }

    void printArray() {
        System.out.print("[");
        for (int i = 0; i < this.array.length - 1; i++) {
            System.out.print(this.array[i] + ",");
        }
        System.out.print(this.array[this.array.length - 1] + "]");
    }

    public static void main(final String[] args) {

        // 1) Creare un array circolare di dieci elementi
        MyCircularArray circularArray = new MyCircularArray();

        // 2) Aggiungere gli elementi da 1 a 10 e stampare il contenuto
        // dell'array circolare
        for (int i = 1; i <= 10; i++) {
            circularArray.add(i);
        }
        circularArray.printArray();

        // 3) Aggiungere gli elementi da 11 a 15 e stampare il contenuto
        // dell'array circolare
        for (int i = 11; i <= 15; i++) {
            circularArray.add(i);
        }
        circularArray.printArray();

        // 4) Invocare il metodo reset
        circularArray.reset();
        circularArray.printArray();


        // 5) Stampare il contenuto dell'array circolare
        circularArray.printArray();


        // 6) Aggiungere altri elementi a piacere e stampare il contenuto
        // dell'array circolare
        circularArray.add(42);
        circularArray.add(43);
        circularArray.add(44);
        circularArray.printArray();
    }
}
