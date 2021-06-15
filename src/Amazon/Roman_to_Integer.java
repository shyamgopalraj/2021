package Amazon;

import java.util.*;

public class Roman_to_Integer {

    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c == 'V' && index - 1 >= 0 && s.charAt(index - 1) == 'I') {
                result += map.get(c) - 2;
            } else if (c == 'X' && index - 1 >= 0 && s.charAt(index - 1) == 'I') {
                result += map.get(c) - 2;
            } else if (c == 'L' && index - 1 >= 0 && s.charAt(index - 1) == 'X') {
                result += map.get(c) - 20;
            } else if (c == 'C' && index - 1 >= 0 && s.charAt(index - 1) == 'X') {
                result += map.get(c) - 20;
            } else if (c == 'D' && index - 1 >= 0 && s.charAt(index - 1) == 'C') {
                result += map.get(c) - 200;
            } else if (c == 'M' && index - 1 >= 0 && s.charAt(index - 1) == 'C') {
                result += map.get(c) - 200;
            } else {
                result += map.get(c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Roman_to_Integer obj = new Roman_to_Integer();
        String s = "MCMXCIV";
        int result = obj.romanToInt(s);
        System.out.println(result);
    }

}
