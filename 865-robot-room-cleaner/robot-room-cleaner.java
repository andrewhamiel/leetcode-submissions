/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    //right-hand rule
    private int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //up/right/down/left
    private Set<Pair<Integer, Integer>> visited = new HashSet<>();
    private Robot robot;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    private void backtrack(int row, int col, int dir){
      visited.add(new Pair<>(row, col));
      robot.clean();
      for(int i = 0; i < 4; i++){
        int newDir = (dir + i) % 4;
        int newRow = row + dirs[newDir][0], newCol = col + dirs[newDir][1];
        if(!visited.contains(new Pair<>(newRow, newCol)) && robot.move()){
          backtrack(newRow, newCol, newDir);
          goBack();
        }
        //turn clockwise
        robot.turnRight();
      }
    }

    private void goBack(){
      robot.turnRight();
      robot.turnRight();
      robot.move();
      robot.turnRight();
      robot.turnRight();
    }
}