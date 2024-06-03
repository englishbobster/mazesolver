package stos.utils;

import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {

  private int playerOneScore = 0;
  private int playerTwoScore = 0;
  private final Map<Integer, String> ordinalToText = new HashMap<>() {
    {
      put(0, "Love");
      put(1, "Fifteen");
      put(2, "Thirty");
    }
  };

  public String getScore() {
    if (playerOneScore == 3 && playerTwoScore == 3) {
      return "Deuce";
    } else if (playerOneScore == playerTwoScore) {
      return ordinalToText.get(playerOneScore) + ' ' + "All";
    } else if (playerOneScore > 3) {
      return "Game Player One";
    } else if (playerTwoScore > 3) {
      return "Game Player Two";
    }
    return ordinalToText.get(playerOneScore) + ' ' + ordinalToText.get(playerTwoScore);
  }

  public void playerOneScores() {
    playerOneScore++;
  }

  public void playerTwoScores() {
    playerTwoScore++;
  }
}
