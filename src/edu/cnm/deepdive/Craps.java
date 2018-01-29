package edu.cnm.deepdive;

import java.util.Random;

public class Craps {

  private int plays = 0;
  private int wins = 0;
  private State state = State.COME_OUT;
  private Random rng = new Random();

  public int getPlays() {
    return plays;
  }


  public int getWin() {
    return wins;
  }

  public State getState() {
    return state;
  }

  public void reset() {
    wins = 0;
    plays = 0;
    state = State.COME_OUT;
  }

  public int roll() {
    int sum = rng.nextInt(6) + rng.nextInt(6) +2;
    state = state.roll(sum);
    if (state == State.WIN) {
      wins++;
    }
    return sum;
  }

  public void play() {
    state = State.COME_OUT;
    plays++;
  }

  public enum State {
  COME_OUT, WIN, LOSS, POINT, TERMINAL;

  private int point = 0;

  public State roll(int diceSum) {
    switch (this) {
      case COME_OUT:
      switch (diceSum) {
        case 2:
        case 3:
        case 12:
          return LOSS;
        case 7:
        case 11:
          return WIN;
        default:
          POINT.point = diceSum;
          return POINT;
      }
      case POINT:
        if (diceSum == point) {
          return WIN;
        } else if (diceSum == 7) {
          return LOSS;
        } else {
          return this;
        }
      default:
        return this;
    }
   }

    public State playAgain() {
    if (this == WIN || this == LOSS ) {
      return COME_OUT;
    } else {
      return this;
    }
    }

    public State surrender() {
    if (this != COME_OUT) {
      return TERMINAL;
    } else {
      return this;
    }
    }
  }

}
