package General;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {

        int start = 0;
        int end = A.length - 1;

        while (start < end) {
            // Elements at the start of the array is Even
            if (A[start] % 2 == 0) {
                start++;
            }
            // Elements at the start of the array is odd
            else {
                // check if end element is even, then swap
                if (A[end] % 2 == 0) {
                    int temp = A[end];
                    A[end] = A[start];
                    A[start] = temp;
                    start++;
                    end--;
                }
                // if the last elmment is odd, decrement end
                else {
                    end--;
                }
            }
        }

        return A;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
