package stos.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TennisScoringTest {

  @Test
  void start_of_game_give_zero_love() {
    var scoreBoard = new ScoreBoard();
    var score = scoreBoard.getScore();
    assertEquals("Love All", score);
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

  @Test
  void player_one_takes_the_game_clean_sheet() {
    var scoreBoard = new ScoreBoard();
    scoreBoard.playerOneScores();
    scoreBoard.playerOneScores();
    scoreBoard.playerOneScores();
    scoreBoard.playerOneScores();
    var score = scoreBoard.getScore();
    assertEquals("Game Player One", score);
  }

  @Test
  void player_two_takes_the_game_clean_sheet() {
    var scoreBoard = new ScoreBoard();
    scoreBoard.playerTwoScores();
    scoreBoard.playerTwoScores();
    scoreBoard.playerTwoScores();
    scoreBoard.playerTwoScores();
    var score = scoreBoard.getScore();
    assertEquals("Game Player Two", score);
  }

  @Test
  void player_one_and_two_are_equal_on_forty_points() {
    var scoreBoard = new ScoreBoard();
    scoreBoard.playerTwoScores();
    scoreBoard.playerTwoScores();
    scoreBoard.playerTwoScores();

    scoreBoard.playerOneScores();
    scoreBoard.playerOneScores();
    scoreBoard.playerOneScores();

    var score = scoreBoard.getScore();
    assertEquals("Deuce", score);
  }

}