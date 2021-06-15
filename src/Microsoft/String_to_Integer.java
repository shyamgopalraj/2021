package Microsoft;

public class String_to_Integer {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty())
            return 0;
        long result = 0;
        char c;
        // default value set to '+'
        char flag = '+';
        for (int index = 0; index < s.length(); index++) {
            c = s.charAt(index);
            if (index == 0 && (c == '-' || c == '+')) {
                flag = c;
            } else {
                if (Character.isDigit(c)) {
                    int digit = c - '0';
                    result = result * 10;
                    result = result + digit;

                    if (flag == '-') {
                        if (-result <= Integer.MIN_VALUE) {
                            return Integer.MIN_VALUE;
                        }
                    } else {
                        if (result >= Integer.MAX_VALUE) {
                            return Integer.MAX_VALUE;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        //
        if (flag == '-') {
            return (int) result * -1;
        }
        return (int) result;

    }

    public static void main(String[] args) {
        String_to_Integer obj = new String_to_Integer();
        System.out.println(Integer.MIN_VALUE);
        int result = obj.myAtoi("+1");
        System.out.println(result);
    }

}
