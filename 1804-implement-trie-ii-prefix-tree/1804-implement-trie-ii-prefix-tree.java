class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null)
                cur.children[index] = new TrieNode();
            cur.children[index].count++;
            cur = cur.children[index];
        }
        cur.end++;
    }
    
    public int countWordsEqualTo(String word) {
        int min = 2000;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null)
                return 0;
            min = Math.min(min, cur.children[index].count);
            cur = cur.children[index];
        }
        return Math.min(min, cur.end);
    }
    
    public int countWordsStartingWith(String prefix) {
        int min = 2000;
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null)
                return 0;
            min = Math.min(min, cur.children[index].count);
            cur = cur.children[index];
        }
        return min;
    }
    
    public void erase(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            cur.children[index].count--;
            cur = cur.children[index];
        }
        cur.end--;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int count;
    int end;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */