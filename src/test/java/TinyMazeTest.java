import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import stos.utils.MazeSolver;

public class TinyMazeTest {

  @Test
  void emptyMaze() {
    var mazeSolver = new MazeSolver();
    var solvedMaze = mazeSolver.solve(new String[][]{});
    assertEquals(0, solvedMaze.length);
  }

  //given [[:S :E]]
  //then [[:x :x]]
  @Test
  void simplestMaze() {
    var mazeSolver = new MazeSolver();
    String[][] maze = new String[][]{new String[]{":S", ":E"}};
    var solvedMaze = mazeSolver.solve(maze);
    assertEquals(":x", solvedMaze[0][0]);
    assertEquals(":x", solvedMaze[0][1]);
  }

  //given [[:S 0 :E]]
  //then [[:x :x :x]]
  @Test
  void simplestMaze2() {
    var mazeSolver = new MazeSolver();
    String[][] maze = new String[][]{new String[]{":S", "0", ":E"}};
    var solvedMaze = mazeSolver.solve(maze);
    assertEquals(":x", solvedMaze[0][0]);
    assertEquals(":x", solvedMaze[0][1]);
    assertEquals(":x", solvedMaze[0][2]);
  }

  @Test
  void unsolvableMazeWithWall() {
    var mazeSolver = new MazeSolver();
    String[][] maze = new String[][]{new String[]{":S", "1", ":E"}};
    var solvedMaze = mazeSolver.solve(maze);
    assertEquals(":S", solvedMaze[0][0]);
    assertEquals("1", solvedMaze[0][1]);
    assertEquals(":E", solvedMaze[0][2]);
  }

  @Test
  void solvableTwoLayerMaze() {
    var mazeSolver = new MazeSolver();
    String[][] maze = new String[][]{new String[]{":S"}, new String[]{":E"}};
    var solvedMaze = mazeSolver.solve(maze);
    assertEquals(":x", solvedMaze[0][0]);
    assertEquals(":x", solvedMaze[1][0]);
  }

  //[[:S 0],
  //[ 0 :E]]
  @Test
  void solvableTwoLayerMazeWithTwoPossibilities() {
    var mazeSolver = new MazeSolver();
    String[][] maze = new String[][]{new String[]{":S", "0"}, new String[]{"0", ":E"}};
    var solvedMaze = mazeSolver.solve(maze);
    assertEquals(":x", solvedMaze[0][0]);
    assertEquals(":x", solvedMaze[0][1]);
    assertEquals("0", solvedMaze[1][0]);
    assertEquals(":x", solvedMaze[1][1]);
  }

  //[[:S 0 0],
  //[ 0 :E 0]]
  @Test
  void solvableTwoLayerMazeWithTwoPossibilitiesButSomething() {
    var mazeSolver = new MazeSolver();
    String[][] maze = new String[][]{new String[]{":S", "0", "0"}, new String[]{"0", ":E", "0"}};
    var solvedMaze = mazeSolver.solve(maze);
    assertEquals(":x", solvedMaze[0][0]);
    assertEquals(":x", solvedMaze[0][1]);
    assertEquals(":x", solvedMaze[0][2]);
    assertEquals(":x", solvedMaze[1][2]);
    assertEquals(":x", solvedMaze[1][1]);
    assertEquals("0", solvedMaze[1][0]);
  }

  @Test
  void solvableTwoLayerMazeWithTwoPossibilitiesButSomething2() {
    var mazeSolver = new MazeSolver();
    String[][] maze = new String[][]{new String[]{":S", "0", "0"}, new String[]{":E", "0", "0"}};
    var solvedMaze = mazeSolver.solve(maze);
    assertEquals(":x", solvedMaze[0][0]);
    assertEquals(":x", solvedMaze[0][1]);
    assertEquals(":x", solvedMaze[0][2]);
    assertEquals(":x", solvedMaze[1][2]);
    assertEquals(":x", solvedMaze[1][1]);
    assertEquals(":x", solvedMaze[1][0]);
  }

  //[[:S 0 0],
  //[ 0 :E 0]],
  //[ 0 0 0]]
  //
  // [[:x :x :x],
  // [[:x :x :x],
  // [[:x :x :x]

  @Test
  void solvableThreeLayerMaze() {
    var mazeSolver = new MazeSolver();
    String[][] maze = {new String[]{":S", "0", "0"}, new String[]{"0", ":E", "0"}, new String[]{"0", "0", "0"}};
    String[][] solvedMaze = mazeSolver.solve(maze);
    printMaze(solvedMaze);
    assertEquals(":x", solvedMaze[0][0]);
    assertEquals(":x", solvedMaze[0][1]);
    assertEquals(":x", solvedMaze[0][2]);
    assertEquals(":x", solvedMaze[1][2]);
    assertEquals(":x", solvedMaze[1][1]);
    assertEquals(":x", solvedMaze[1][0]);
    assertEquals(":x", solvedMaze[2][2]);
    assertEquals(":x", solvedMaze[2][1]);
    assertEquals(":x", solvedMaze[2][0]);
  }

  private void printMaze(String[][] solvedMaze) {
    for (int i = 0; i < solvedMaze.length; i++) {
      for (int j = 0; j <solvedMaze[0].length; j++) {
        System.out.print(solvedMaze[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
