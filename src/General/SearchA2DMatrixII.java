package General;

public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int shorterDimension = Math.min(rowLength, colLength);

        for (int index = 0; index < shorterDimension; index++) {
            // Binary search on column and row. Set true for row, false for column.
            if (binarySearch(matrix, index, target, true) || binarySearch(matrix, index, target, false)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int start, int target, boolean rowSearch) {
        int low = start;
        int high = rowSearch ? matrix.length - 1 : matrix[0].length - 1;
        while (low <= high) {
            if (rowSearch) {
                int mid = (low + high) / 2;
                if (matrix[mid][start] == target)
                    return true;
                else {
                    if (matrix[mid][start] > target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            // column search
            else {
                int mid = (low + high) / 2;
                if (matrix[start][mid] == target)
                    return true;
                else {
                    if (matrix[start][mid] > target)
                        high = mid - 1;
                    else
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
