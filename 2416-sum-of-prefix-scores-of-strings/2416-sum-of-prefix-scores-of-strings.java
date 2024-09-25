class Solution {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new TrieNode();
            cur.children[c - 'a'].count++;
            cur = cur.children[c - 'a'];
        }
    }

    int count(String word) {
        int cnt = 0;
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cnt += cur.children[c - 'a'].count;
            cur = cur.children[c - 'a'];
        }
        return cnt;
    }

    public int[] sumPrefixScores(String[] words) {
        int[] ans = new int[words.length];
        for (String word : words) {
            insert(word);
        }
        for (int i = 0; i < words.length; i++) {
            ans[i] = count(words[i]);
        }
        return ans;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int count;
}