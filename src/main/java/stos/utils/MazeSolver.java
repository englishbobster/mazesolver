package stos.utils;

import org.apache.commons.lang3.SerializationUtils;

import java.util.Arrays;

public class MazeSolver {

  public String[][] solve(String[][] maze) {
    if (maze.length == 0) {
      return new String[][]{};
    }

    if (Arrays.asList(maze[0]).contains("1")) {
      return maze;
    }

    String[][] result = SerializationUtils.clone(maze);

    int x = 0;
    int y = 0;
    while (!hasReachedTheEnd(maze, x, y)) {
      while ((maze[0].length < x + 1) && !(result[x + 1][y].equals(":x"))) {
        result[x][y]=":x";
        x++;
      }
      while (maze.length < y + 1) {
        result[x][y]=":x";
        y++;
      }
      while (x > 0) {
        result[x][y]=":x";
        x--;
      }
      while ((y > 0) && !(result[x][y - 1].equals(":x"))) {
        result[x][y]=":x";
        y--;
      }
    }
    return result;
  }

  private boolean hasReachedTheEnd(String[][] maze, int x, int y) {
    return maze[x][y].equals(":E");
  }
}
