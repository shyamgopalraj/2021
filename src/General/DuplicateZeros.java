package General;

public class DuplicateZeros {

    // Time Complexity ) O(n2)
    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == 0) {
                // shift elements
                for (int j = length - 2; j >= i + 1; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[i + 1] = 0;
                i++;
            }
        }
    }

    // Using two pass approach
    public void TwoPassApproach(int[] arr) {

        int numberOfZeros = 0;
        int length = arr.length - 1;

        for (int i = 0; i <= length - numberOfZeros; i++) {
            if (arr[i] == 0) {
                if (i == length - numberOfZeros) {
                    arr[length] = 0;
                    length -= 1;
                    break;
                }
                numberOfZeros++;
            }
        }

        int last = length - numberOfZeros;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + numberOfZeros] = 0;
                numberOfZeros--;
                arr[i + numberOfZeros] = 0;
            } else {
                arr[i + numberOfZeros] = arr[i];
            }
        }

    }

    public static void main(String[] args) {

    }

}
