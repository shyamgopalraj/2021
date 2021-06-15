package Microsoft;

public class Valid_Palindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            else if (Character.isDigit(s.charAt(start)) || Character.isDigit(s.charAt(end))) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                } else
                    return false;
            } else {
                if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))) {
                    start++;
                    end--;
                } else
                    return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Valid_Palindrome obj = new Valid_Palindrome();
        String s = "0P";
        if (obj.isPalindrome(s))
            System.out.println("Its a Palindrome !!!");
        else
            System.out.println("Its not Palindrome !!!");
    }

}
