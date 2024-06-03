package stos.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TennisScoringTest {

  @Test
  void start_of_game_give_zero_love() {
    var scoreBoard = new ScoreBoard();
    var score = scoreBoard.getScore();
    assertEquals("Zero Love", score);
  }

  @Test
  void player_one_scores_first_give_fifteen_love() {
    var scoreBoard = new ScoreBoard();
    scoreBoard.playerOneScores();
    var score = scoreBoard.getScore();
    assertEquals("Fifteen Love", score);
  }

  @Test
  void player_two_scores_first_gives_love_fifteen() {
    var scoreBoard = new ScoreBoard();
    scoreBoard.playerTwoScores();
    var score = scoreBoard.getScore();
    assertEquals("Love Fifteen", score);
  }

  @Test
  void player_two_scores_twice_gives_love_thirty() {
    var scoreBoard = new ScoreBoard();
    scoreBoard.playerTwoScores();
    scoreBoard.playerTwoScores();
    var score = scoreBoard.getScore();
    assertEquals("Love Thirty", score);
  }

  @Test
  void both_players_score_gives_fifteen_all() {
    var scoreBoard = new ScoreBoard();
    scoreBoard.playerOneScores();
    scoreBoard.playerTwoScores();
    var score = scoreBoard.getScore();
    assertEquals("Fifteen All", score);
  }
}