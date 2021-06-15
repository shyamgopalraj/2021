package General;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "xywz");
        if (digits.trim().length() > 0) {
            findAllCombinations(map, digits, new StringBuilder(), result, 0);
        }
        return result;
    }

    private void findAllCombinations(Map<Character, String> map, String digits, StringBuilder stringBuilder,
            List<String> result, int index) {
        if (stringBuilder.length() == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        char c = digits.charAt(index);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            findAllCombinations(map, digits, stringBuilder, result, index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        Letter_Combinations_of_a_Phone_Number obj = new Letter_Combinations_of_a_Phone_Number();
        List<String> result = obj.letterCombinations(" ");
        System.out.println(result);
    }

}
