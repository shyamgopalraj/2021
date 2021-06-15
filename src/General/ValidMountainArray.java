package General;

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        int i = 0;

        while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == arr.length - 1)
            return false;

        while (i + 1 < arr.length && arr[i] > arr[i + 1])
            i++;

        if (i == arr.length - 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
