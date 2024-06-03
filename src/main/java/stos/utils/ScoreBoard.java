package stos.utils;

public class ScoreBoard {

  private int playerOneScore = 0;
  private int playerTwoScore = 0;

  public String getScore() {
    if (playerOneScore == 1 && playerTwoScore == 0) {
      return "Fifteen Love";
    } else if (playerOneScore == 1 && playerTwoScore == 1) {
      return "Fifteen All";
    }

    if (playerTwoScore == 1) {
      return "Love Fifteen";
    } else if (playerTwoScore == 2) {
      return "Love Thirty";
    }
    return "Zero Love";
  }

  public void playerOneScores() {
    playerOneScore++;
  }

  public void playerTwoScores() {
    playerTwoScore++;
  }
}
