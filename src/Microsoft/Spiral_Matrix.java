package Microsoft;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int col = colStart; col <= colEnd; col++) {
                result.add(matrix[rowStart][col]);
            }

            for (int row = rowStart + 1; row <= rowEnd; row++) {
                result.add(matrix[row][colEnd]);
            }

            if (rowStart < rowEnd && colStart < colEnd) {
                for (int col = colEnd - 1; col >= colStart; col--) {
                    result.add(matrix[rowEnd][col]);
                }

                for (int row = rowEnd - 1; row > rowStart; row--) {
                    result.add(matrix[row][colStart]);
                }
            }

            colStart++;
            colEnd--;
            rowStart++;
            rowEnd--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        Spiral_Matrix obj = new Spiral_Matrix();
        List<Integer> result = obj.spiralOrder(matrix);
        System.out.println(result);

    }

}
