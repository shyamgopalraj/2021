package General;

public class Search_a_2D_Matrix_II {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int minLength = Math.min(rowLength, colLength);

        for (int index = 0; index < minLength; index++) {
            if (search(matrix, index, target, true) || search(matrix, index, target, false)) {
                return true;
            }
        }
        return false;
    }

    private boolean search(int[][] matrix, int index, int target, boolean rowSearch) {

        int low = 0;
        int high = rowSearch ? matrix.length - 1 : matrix[0].length - 1;

        if (rowSearch) {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[mid][index] == target) {
                    return true;
                }
                if (matrix[mid][index] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        } else {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[index][mid] == target) {
                    return true;
                }
                if (matrix[index][mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
