package Microsoft;

import java.util.Stack;

public class Valid_Parentheses {

    public boolean isValid(String s) {
        if (s.isEmpty() || s == null || s.trim().length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (!stack.isEmpty()) {
                    if ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}')
                            || (stack.peek() == '[' && c == ']')) {
                        stack.pop();
                    } else
                        return false;

                } else
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Valid_Parentheses obj = new Valid_Parentheses();
        String s = "{[]}";
        if (obj.isValid(s)) {
            System.out.println("Valid!!");
        } else
            System.out.println("InValid...");
    }

}
