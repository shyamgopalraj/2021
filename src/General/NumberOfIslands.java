package General;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int islandCount = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        boolean[][] visited = new boolean[rowLength][colLength];

        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    visited[r][c] = true;
                    findIsland(grid, visited, r, c);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void findIsland(char[][] grid, boolean[][] visited, int r, int c) {
        int[] rows = { 0, 1, 0, -1 };
        int[] cols = { 1, 0, -1, 0 };

        for (int i = 0; i < 4; i++) {
            int row = r + rows[i];
            int col = c + cols[i];

            if ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length) && grid[row][col] == '1'
                    && !visited[row][col]) {
                visited[row][col] = true;
                findIsland(grid, visited, row, col);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stuba
//        char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
//                { '0', '0', '0', '0', '0' } };
        char[][] grid = {{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int result = numberOfIslands.numIslands(grid);
        System.out.println("result: " + result);

    }

}
