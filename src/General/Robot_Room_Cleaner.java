package General;

import java.util.HashSet;
import java.util.Set;

public class Robot_Room_Cleaner {

    // This is the robot's control interface.
    // You should not implement it, or speculate about its implementation
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    Set<int[]> visited = new HashSet<>();
    // clockwise movement: up,right,down,left
    int[] rowMovement = { -1, 0, 1, 0 };
    int[] colMovement = { 0, 1, 0, -1 };
    Robot robot;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backTrack(0, 0, 0);
    }

    private void backTrack(int row, int col, int dimension) {
        visited.add(new int[] { row, col });
        robot.clean();

        for (int index = 0; index < 4; index++) {
            int newDimension = (index + dimension) % 4;
            int newRow = row + rowMovement[newDimension];
            int newCol = col + colMovement[newDimension];

            int[] pos = { newRow, newCol };

            if (!visited.contains(pos) && robot.move()) {
                backTrack(newRow, newCol, newDimension);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            robot.turnRight();
        }
    }

}
