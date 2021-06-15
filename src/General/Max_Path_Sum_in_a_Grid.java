package General;

public class Max_Path_Sum_in_a_Grid {

    public int solution(int[][] matrix) {
        int maxRowLength = matrix.length;
        int maxColLength = matrix[0].length;
        int[][] dpSum = new int[maxRowLength][maxColLength];
        for (int r = 0; r < maxRowLength; r++) {
            for (int c = 0; c < maxColLength; c++) {
                dpSum[r][c] = matrix[r][c] + Math.max((r == 0 ? 0 : dpSum[r - 1][c]), (c == 0 ? 0 : dpSum[r][c - 1]));
            }
        }
        return dpSum[maxRowLength - 1][maxColLength - 1];
    }

    public static void main(String[] args) {
        Max_Path_Sum_in_a_Grid obj = new Max_Path_Sum_in_a_Grid();
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int maxSum = obj.solution(matrix);
        System.out.println(maxSum);
    }

}
