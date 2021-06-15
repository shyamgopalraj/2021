package General;

import java.util.Arrays;

public class Reverse_String {

    public static void reverseString(char[] s) {
        reverse(0, s.length - 1, s);
        int[] a = {1,2};
        change(a);
        System.out.println(Arrays.toString(a));
        System.out.println(String.valueOf(s));
    }

    private static void change(int[] a) {
        a[0] = 10;
        a[1] = 20;
    }

    private static void reverse(int left, int right, char[] s) {
        if (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
            reverse(left, right, s);
        }
    }

    public static void main(String[] args) {
        String a = "Shyam";
        char[] s = a.toCharArray();
        reverseString(s);
    }
}
