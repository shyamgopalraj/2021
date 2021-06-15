package Microsoft;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    class TrieNode {

        Map<Character, TrieNode> map;
        boolean endOfWord;

        public TrieNode() {
            map = new HashMap<>();
            endOfWord = false;
        }

    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode trieNode = null;
        TrieNode curNode = root;
        for (int index = 0; index < word.length(); index++) {
            char c = word.charAt(index);
            Map<Character, TrieNode> map = curNode.map;
            trieNode = map.get(c);
            // No mapping exist
            if (trieNode == null) {
                map.put(c, new TrieNode());
            }
            // mapping exist
            trieNode = map.get(c);
            curNode = trieNode;
        }
        trieNode.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode trieNode = null;
        TrieNode curNode = root;
        for (int index = 0; index < word.length(); index++) {
            char c = word.charAt(index);
            Map<Character, TrieNode> map = curNode.map;
            trieNode = map.get(c);
            // No mapping exist
            if (trieNode == null) {
                return false;
            }
            // mapping exist
            curNode = trieNode;
        }
        return trieNode.endOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = null;
        TrieNode curNode = root;
        for (int index = 0; index < prefix.length(); index++) {
            char c = prefix.charAt(index);
            Map<Character, TrieNode> map = curNode.map;
            trieNode = map.get(c);
            // No mapping exist
            if (trieNode == null) {
                return false;
            }
            // mapping exist
            curNode = trieNode;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.startsWith("ap");

    }

}
