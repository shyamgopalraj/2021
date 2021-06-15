package Amazon;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty() || s.length() == 0)
            return 0;

        int maxLength = 1;
        int cur = 0;
        int next = cur + 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(cur));
        while (next < s.length()) {
            char nextChar = s.charAt(next);
            if (!set.contains(nextChar)) {
                set.add(nextChar);
                maxLength = Math.max(maxLength, set.size());
            }
            // duplicate found
            else {
                while (s.charAt(cur) != nextChar) {
                    set.remove(s.charAt(cur));
                    cur++;
                }
                cur = cur + 1;
            }
            next++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters obj = new Longest_Substring_Without_Repeating_Characters();
        String s = "abcabcbb";
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println(result);

    }

}
