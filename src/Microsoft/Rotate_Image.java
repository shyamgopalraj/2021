package Microsoft;

//Youtube explaination: https://www.youtube.com/watch?v=fMSJSS7eO1w&ab_channel=NeetCode
public class Rotate_Image {
    
    // It will be always an nxn matrix
    public void rotate(int[][] matrix) {
        
        int left = 0;
        int right = matrix.length-1;
        
        while(left < right) {
            int top = left;
            int bottom = right;
            for(int index = 0;index <(right-left);index++) {
                
                int temp = matrix[top][left+index];
                matrix[top][left+index] = matrix[bottom-index][left];
                matrix[bottom-index][left] = matrix[bottom][right-index];
                matrix[bottom][right-index] = matrix[top+index][right];
                matrix[top+index][right] = temp;
            }
            left++;
            right--;
        }
    }
    
    private void display(int[][] matrix) {
        for(int r=0;r<matrix.length;r++) {
            for(int c=0;c<matrix.length;c++) {
                System.out.print(matrix[r][c]+",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        Rotate_Image obj = new Rotate_Image();
        obj.display(matrix);
        System.out.println();
        obj.rotate(matrix);
        obj.display(matrix);
    }

}
