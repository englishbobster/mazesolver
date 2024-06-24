package stos.utils;

import java.util.Arrays;
import org.apache.commons.lang3.SerializationUtils;

public class MazeSolver {

  public String[][] solve(String[][] maze) {
    if (maze.length == 0) {
      return new String[][]{};
    }

    if (Arrays.asList(maze[0]).contains("1")) {
      return maze;
    }

    String[][] result = SerializationUtils.clone(maze);
    int lastKnownColumnPosition = 0;
    int lastKnownRowPosition = 0;
    for (int column = 0; column < maze[0].length; column++) {
      result[0][column] = ":x";
      lastKnownColumnPosition = column;
    }
    for (int row = 0; row < maze.length; row++) {
      result[row][lastKnownColumnPosition] = ":x";
      lastKnownRowPosition = row;
    }
    if (!maze[lastKnownRowPosition][lastKnownColumnPosition].equals(":E")) {
      for (int column = lastKnownColumnPosition; column >= 0; column--) {
        result[lastKnownRowPosition][column] = ":x";
        if(maze[lastKnownRowPosition][column].equals(":E")) {
          break;
        }
      }
    }

    return result;
  }
}
