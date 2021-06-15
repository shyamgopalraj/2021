package Microsoft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Words {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair<String, Integer>> queue = new PriorityQueue<>(k, new Comparator<Pair<String, Integer>>() {

            @Override
            public int compare(Pair<String, Integer> p1, Pair<String, Integer> p2) {
                return p1.second - p2.second;
            }
        });

        for (String word : words) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                count++;
                map.put(word, count);
            } else {
                map.put(word, 1);
            }
        }

            for (String key : map.keySet()) {
                Pair<String, Integer> pair = new Pair<String, Integer>(key, map.get(key));
                queue.add(pair);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            
            List<String> result = new ArrayList<String>();
            while(!queue.isEmpty()) {
                result.add(queue.poll().first);
            }
            return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
