package edu.cnm.deepdive.craps.controllers;


import edu.cnm.deepdive.craps.model.Craps;
import java.util.Scanner;

public class Play {

  public static void main(String[] args) {
    int autoPlays = (args.length > 0  ? Integer.parseInt(args[0]) : 0);
    Craps craps = new Craps();
    Scanner scanner = new Scanner(System.in);
    int wins = 0;
    int plays = 0;
    do {
      plays++;
      Craps.State result = craps.play();
      if (result == Craps.State.WIN) {
        wins++;
      }
      if (plays >= autoPlays) {
        for (int[] dice : craps.getRolls()) {
          System.out.printf("%d %d%n", dice[0], dice[1]);
        }
        System.out.println(result);
        System.out.printf("Plays: %d. Wins %d. Winning percentage: %.2f%%%n",
            plays, wins, 100.0 * wins / plays);
        System.out.println("Play again? [Y/n]");
        String input = scanner.nextLine()
            .trim()
            .toLowerCase();
        if (!input.isEmpty() && input.charAt(0) == 'n') {
          break;
        }
      }

    } while (true);

  }

}

