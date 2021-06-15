package Amazon;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    class TrieNode {

        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.endOfWord = false;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean delete(String word) {
        return searchAndDelete(word, 0, root);
    }

    private boolean searchAndDelete(String word, int index, TrieNode cur) {

        if (index == word.length()) {

            if (cur.endOfWord) {
                cur.endOfWord = false;
                Map<Character, TrieNode> children = cur.children;
                if (children.isEmpty()) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        Map<Character, TrieNode> children = cur.children;
        char charToBeSearched = word.charAt(index);
        cur = children.get(charToBeSearched);
        // word not present
        if (cur == null)
            return false;
        boolean deleteCurrentNode = searchAndDelete(word, index + 1, cur);

        if (deleteCurrentNode) {
            // this cur is the trieNode of the last char of word to be searched
            cur.children.remove(charToBeSearched);
            if (cur.children.isEmpty()) {
                return true;
            }
            return false;

        }
        return false;
    }

}
