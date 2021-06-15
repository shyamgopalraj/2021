package Microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] cArray = word.toCharArray();
            Arrays.sort(cArray);
            String sortedString = String.valueOf(cArray);
            if (map.containsKey(sortedString)) {
                List<String> list = map.get(sortedString);
                list.add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sortedString, list);
            }
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    public static void main(String[] args) {
        Group_Anagrams obj = new Group_Anagrams();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = obj.groupAnagrams(strs);
        System.out.println(result);
    }

}
