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

  //[[:S :E]]
  //[[:x :x]]
  @Test
  void simplestMaze() {
    var mazeSolver = new MazeSolver();
    String[][] maze = new String[][]{new String[]{":S", ":E"}};
    var solvedMaze = mazeSolver.solve(maze);
    assertEquals(":x", solvedMaze[0][0]);
    assertEquals(":x", solvedMaze[0][1]);
  }

  //[[:S 0 :E]]
  //[[:x :x :x]]
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

}
