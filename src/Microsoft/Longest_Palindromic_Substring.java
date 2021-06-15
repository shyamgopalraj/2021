package Microsoft;

public class Longest_Palindromic_Substring {

    int start = 0;
    int end = 0;
    int length = 0;

    public String longestPalindrome(String s) {
        if (s.isEmpty() || s == null) {
            return s;
        }

        for (int index = 1; index < s.length(); index++) {
            find(index - 1, index, s);
            find(index - 1, index + 1, s);
        }
        return s.substring(start, end + 1);
    }

    private void find(int leftIndex, int rightIndex, String s) {
        boolean found = false;
        while (leftIndex >= 0 && rightIndex < s.length()) {
            char leftChar = s.charAt(leftIndex);
            char rightChar = s.charAt(rightIndex);
            if (leftChar == rightChar) {
                found = true;
                leftIndex--;
                rightIndex++;
            } else {
                break;
            }
        }

        if (found) {
            leftIndex++;
            rightIndex--;
            if (rightIndex - leftIndex + 1 > length) {
                length = rightIndex - leftIndex + 1;
                start = leftIndex;
                end = rightIndex;
            }
        }
    }

    public static void main(String[] args) {
        Longest_Palindromic_Substring obj = new Longest_Palindromic_Substring();
        String s = "babad";
        String result = obj.longestPalindrome(s);
        System.out.println(result);
    }
}
