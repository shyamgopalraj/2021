package Microsoft;

public class Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int minLength = Math.min(matrix.length, matrix[0].length);

        for (int index = 0; index < minLength; index++) {
            if (search(index, true, matrix, target) || search(index, false, matrix, target)) {
                return true;
            }
        }
        return false;

    }

    private boolean search(int index, boolean rowSearch, int[][] matrix, int target) {

        if (rowSearch) {
            int rowStart = index;
            int rowHigh = matrix.length - 1;
            while (rowStart <= rowHigh) {
                int mid = (rowStart + rowHigh) / 2;
                if (matrix[mid][index] == target) {
                    return true;
                }
                if (matrix[mid][index] > target) {
                    rowHigh = mid - 1;
                } else {
                    rowStart = mid + 1;
                }
            }
            return false;
        }

        // Col Search
        int colStart = index;
        int colHigh = matrix[0].length - 1;
        while (colStart <= colHigh) {
            int mid = (colStart + colHigh) / 2;
            if (matrix[index][mid] == target) {
                return true;
            }
            if (matrix[index][mid] > target) {
                colHigh = mid - 1;
            } else {
                colStart = mid + 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
