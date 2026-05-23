class TestCalculator {
  public static void main(String[] args) {
	  /*
	   * Uncomment the code below once Calculator has been created!
	   */
    /*
    Si verifichi il funzionamento della nuova calcolatrice modificando `TestCalculator` in modo che stampi il valore dei due nuovi campi dopo ogni operazione.
    */
	  
      Calculator calc = new Calculator();
      calc.build();
      System.out.println("1 + 2 =" + calc.add(1, 2));
      System.out.println("Number of operations done: " + calc.nOpDone);
      System.out.println("Last result: " + calc.lastRes);
      System.out.println("-1 - 2 =" + calc.sub(-1, 2));
      System.out.println("Number of operations done: " + calc.nOpDone);
      System.out.println("Last result: " + calc.lastRes);
      System.out.println("6 * 3 =" + calc.mul(6, 3));
      System.out.println("Number of operations done: " + calc.nOpDone);
      System.out.println("Last result: " + calc.lastRes);
      System.out.println("8 / 4 =" + calc.div(8, 4));
      System.out.println("Number of operations done: " + calc.nOpDone);
      System.out.println("Last result: " + calc.lastRes);

  }
}
