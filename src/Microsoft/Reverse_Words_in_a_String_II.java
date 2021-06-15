package Microsoft;

import java.util.Arrays;

public class Reverse_Words_in_a_String_II {

    public void reverseWords(char[] s) {
        reverseArray(s);
        int start = 0;
        int end = 0;
        while (end < s.length) {
            end++;
            if (end == s.length || s[end] == ' ') {
                reverseWord(start, end - 1, s);
                end++;
                start = end;
            }
        }
    }

    private void reverseWord(int start, int end, char[] s) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    private void reverseArray(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] s = { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
        Reverse_Words_in_a_String_II obj = new Reverse_Words_in_a_String_II();
        obj.reverseWords(s);
        System.out.println(Arrays.toString(s));
    }

}
