package edu.cnm.deepdive;


public class Play {

  public static void main(String[] args) {
    Craps craps = new Craps();
    do {
      craps.play();
     do {
        int diceSum = craps.roll();
         System.out.printf("Roll = %d%n", diceSum);
      }  while (craps.getState() != Craps.State.WIN && craps.getState() != Craps.State.LOSS);
      System.out.printf("Result = %s. Total plays = %d. Total wins = %d.%n",
          craps.getState().toString(), craps.getPlays(), craps.getWin());
      // Ask the user if they want to play again.
    }while (true);

  }

}

