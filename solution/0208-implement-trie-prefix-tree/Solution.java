class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean ended;

    public TrieNode() {
        children = new HashMap<>();
        ended = false;
    }

    public void add(char c) {
        children.putIfAbsent(c, new TrieNode());
    }

    public TrieNode get(char c) {
        return children.get(c);
    }

    public boolean contains(char c) {
        return children.containsKey(c);
    }

    public void setEnded() {
        this.ended = true;
    }

    public boolean isEnded() {
        return ended;
    }
}

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (Character c : word.toCharArray()) {
            if (!node.contains(c)) {
                node.add(c);
            }
            node = node.get(c);
        }
        node.setEnded();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnded();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (Character c : prefix.toCharArray()) {
            if (!node.contains(c))
                return null;
            node = node.get(c);
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
