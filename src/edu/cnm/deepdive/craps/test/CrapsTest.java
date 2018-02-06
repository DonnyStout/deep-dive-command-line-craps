package edu.cnm.deepdive.craps.test;

import edu.cnm.deepdive.craps.model.Craps;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class CrapsTest {

  Craps craps;

  @BeforeEach
  void setUp() {
    craps = new Craps();
    Assertions.assertNotNull(craps);
  }

  @RepeatedTest(1000)
  void play() {
    Assertions.assertEquals(0, craps.getRolls().size());
    {
      Craps.State state = craps.play();
      List<int[]> rolls = craps.getRolls();
      Assertions.assertNotEquals(0, craps.getRolls().size());
      int firstRoll = rolls.get(0)[0] + rolls.get(0)[1];
      int lastRolls = rolls.get(rolls.size() - 1)[0] + rolls.get(rolls.size() - 1)[1];
      switch (state) {
        case WIN:
          if (rolls.size() == 1) {
            Assertions.assertTrue(firstRoll == 7 || firstRoll == 11);
          } else {
            Assertions.assertEquals(firstRoll, lastRolls);
            // TODO Check for (and fail if found) a roll of 7;
          }
          break;
        case LOSS:
          if (rolls.size() == 1) {
            Assertions.assertTrue(firstRoll == 2 || firstRoll == 3 ||
                firstRoll == 12);
            // TODO Check for (and fail if found) a first roll of 7 or 11
          } else {
            Assertions.assertEquals(7, lastRolls);
          }
          break;
        default:
          Assertions.fail("Valid play can only end in win or loss state.");
      }
    }
  }
}