package Microsoft;

public class Number_of_Islands {

    boolean[][] visited;

    public int numIslands(char[][] grid) {

        int maxRows = grid.length;
        int maxCols = grid[0].length;

        visited = new boolean[maxRows][maxCols];
        int numOfIslands = 0;

        for (int row = 0; row < maxRows; row++) {
            for (int col = 0; col < maxCols; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    visited[row][col] = true;
                    findIsland(row, col, grid);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;

    }

    private void findIsland(int row, int col, char[][] grid) {

        // Possible row movements
        int r[] = { 0, 1, 0, -1 };
        int c[] = { 1, 0, -1, 0 };

        for (int index = 0; index < 4; index++) {
            int newRow = row + r[index];
            int newCol = col + c[index];

            if ((newRow >= 0 && newRow < grid.length) && (newCol >= 0 && newCol < grid[0].length)) {
                if (!visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                    visited[newRow][newCol] = true;
                    findIsland(newRow, newCol, grid);
                }
            }
        }
    }

    public static void main(String[] args) {
        Number_of_Islands obj = new Number_of_Islands();
        char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        int numOfIslands = obj.numIslands(grid);
        System.out.println(numOfIslands);
    }

}
