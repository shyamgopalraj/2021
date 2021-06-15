package General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, new Comparator<String>() {
            public int compare(String a, String b) {
                String[] first = a.split(" ", 2);
                String[] second = b.split(" ", 2);

                boolean isChar1 = Character.isAlphabetic(first[1].charAt(0));
                boolean isChar2 = Character.isAlphabetic(second[1].charAt(0));

                if (isChar1 && isChar2) {
                    int compareLogs = first[1].compareTo(second[1]);
                    if (compareLogs == 0) {
                        return first[0].compareTo(second[0]);
                    } else
                        return compareLogs;
                }
                // first one is char and second is number
                else if (isChar1) {
                    return -1;
                }
                // first one is number an second is char
                else if (isChar2) {
                    return 1;
                }
                // both are numbers
                else
                    return 0;
            }
        });
        return logs;
    }
    
    
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String domin : cpdomains) {
            String[] domainSplit = domin.split(" ");
            int count = Integer.parseInt(domainSplit[0]);
            String[] subDomains = domainSplit[1].split("/.");
            String subDomain = "";
            for (int index = subDomain.length(); index >= 0; index--) {
                if (index == subDomain.length()) {
                    subDomain = subDomains[index];
                } else {
                    subDomain = subDomains[index] + "." + subDomain;
                }
                if (map.containsKey(subDomain)) {
                    int val = map.get(subDomain);
                    map.put(subDomain, val + count);
                } else {
                    map.put(subDomain, count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            result.add(Integer.toString(map.get(key)).concat(" " + key));
        }
        return result;
    }
    
    //Find Diameter of binary tree
    int result = 0;

    public int findDepth(TreeNode node) {

        int leftDepth = (node.left == null) ? 0 : findDepth(node.left) + 1;
        int rightDepth = (node.right == null) ? 0 : findDepth(node.right) + 1;
        this.result = Math.max(this.result, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        findDepth(root);
        return result;
    }
    
    //Count and Say
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder prev;

        for (int i = 1; i < n; i++) {
            prev = cur;
            cur = new StringBuilder();
            char previousChar = prev.charAt(0);
            int count = 1;

            for (int j = 1; j < prev.length(); j++) {
                char curChar = prev.charAt(j);
                if (curChar != previousChar) {
                    cur.append(count).append(previousChar);
                    count = 1;
                    previousChar = curChar;
                } else {
                    count++;
                }
            }
            cur.append(count).append(previousChar);
        }
        return cur.toString();
    }
    
  
}
