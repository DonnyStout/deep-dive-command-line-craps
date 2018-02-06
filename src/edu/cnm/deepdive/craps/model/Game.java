package edu.cnm.deepdive.craps.model;

public class Game {

  private Craps craps;
  private long wins;
  private long losses;

  public Game() {
    craps = new Craps();
    reset();
  }

  public void reset() {
   wins = 0;
   losses = 0;
  }

  public Craps getCraps() {
    return craps;
  }

  public long getWins() {
    return wins;
  }

  public long getLosses() {
    return losses;
  }
}
