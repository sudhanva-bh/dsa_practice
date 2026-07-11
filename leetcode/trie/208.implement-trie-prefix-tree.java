/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
import java.util.*;

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean flag = false;
}

class Trie {
    TrieNode head = new TrieNode();

    public Trie() {
    }

    public void insert(String word) {
        TrieNode curr = head;

        for(char c : word.toCharArray()) {
            c -= 'a';
            if(curr.next[c] == null) {
                curr.next[c] = new TrieNode();
            }

            curr = curr.next[c];
        }

        curr.flag = true;
    }

    public boolean search(String word) {
        TrieNode curr = head;

        for(char c : word.toCharArray()) {
            curr = curr.next[c - 'a'];
            if(curr == null) return false;
        }

        return curr.flag;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = head;

        for(char c : prefix.toCharArray()) {
            curr = curr.next[c - 'a'];
            if(curr == null) return false;
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
