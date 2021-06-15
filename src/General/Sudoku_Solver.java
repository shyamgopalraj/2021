package General;

public class Sudoku_Solver {
    
    char[][] board;
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        findSolution(0, 0);
    }

    private boolean findSolution(int row, int col) {

        // all cells filled
        if (row == 8 && col == 9) {
            return true;
        }

        // all cols of existing row are filled
        if (col == 9) {
            row++;
            col = 0;
        }

        if (board[row][col] != '.') {
            return findSolution(row, col + 1);
        }

        for (char num = '1'; num <= '9'; num++) {

            if (isValid(row, col, num) == true) {
                board[row][col] = num;
                // display(board);
                // System.out.println();
                if (findSolution(row, col + 1))
                    return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    private boolean isValid(int row, int col, char num) {
        for (int index = 0; index < 9; index++) {
            if (board[row][index] == num) {
                return false;
            }
        }

        for (int index = 0; index < 9; index++) {
            if (board[index][col] == num) {
                return false;
            }
        }

        int newRow = row - row % 3;
        int newCol = col - col % 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r + newRow][c + newCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public void display(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        Sudoku_Solver obj = new Sudoku_Solver();
        obj.solveSudoku(board);
        obj.display(obj.board);

    }

}
