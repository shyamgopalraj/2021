package General;

import java.util.HashSet;
import java.util.Set;

public class N_Queens_II {

    private int size;

    public int totalNQueens(int n) {
        size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols) {
        if (row == size) {
            return 1;
        }

        int solution = 0;

        for (int col = 0; col < size; col++) {

            int diagonal = row - col;
            int antidiagonal = row + col;

            if (cols.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antidiagonal))
                continue;

            cols.add(col);
            diagonals.add(diagonal);
            antiDiagonals.add(antidiagonal);

            solution += backtrack(row + 1, diagonals, antiDiagonals, cols);

            cols.remove(col);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antidiagonal);
        }

        return solution;
    }

    public static void main(String[] args) {
        N_Queens_II obj = new N_Queens_II();
        System.out.println(obj.totalNQueens(4));
    }

}
