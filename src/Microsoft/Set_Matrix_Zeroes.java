package Microsoft;

public class Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        boolean isFirstCol = false;

        for (int row = 0; row < rowLength; row++) {
            if (matrix[row][0] == 0) {
                isFirstCol = true;
            }
            for (int col = 1; col < colLength; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < rowLength; row++) {
            for (int col = 1; col < colLength; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            
            for (int col = 0; col < colLength; col++) {
                matrix[0][col] = 0;
            }
        }
        
        if (isFirstCol) {
            for (int row = 0; row < rowLength; row++) {
                matrix[row][0] = 0;
            }
        }

    }

    private void display(int[][] matrix) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 0, 7, 8 }, { 0, 10, 11, 12 }, { 13, 14, 15, 0 } };
        Set_Matrix_Zeroes obj = new Set_Matrix_Zeroes();
        obj.setZeroes(matrix);
        obj.display(matrix);
    }

}
