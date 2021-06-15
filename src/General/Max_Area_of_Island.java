package General;

public class Max_Area_of_Island {

    int area = 0;

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        boolean[][] visited = new boolean[rowLength][colLength];

        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    visited[r][c] = true;
                    area = 1;
                    findIsland(grid, visited, r, c);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private void findIsland(int[][] grid, boolean[][] visited, int r, int c) {
        int[] rows = { 0, 1, 0, -1 };
        int[] cols = { 1, 0, -1, 0 };

        for (int i = 0; i < 4; i++) {
            int row = r + rows[i];
            int col = c + cols[i];

            if ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length) && grid[row][col] == '1'
                    && !visited[row][col]) {
                visited[row][col] = true;
                area++;
                findIsland(grid, visited, row, col);
            }
        }
    }

    public static void main(String[] args) {
        Max_Area_of_Island obj = new Max_Area_of_Island();
        int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        int maxArea = obj.maxAreaOfIsland(grid);
        System.out.println(maxArea);
    }

}
