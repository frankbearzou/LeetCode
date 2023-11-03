class Trie {
    private Node head;

    public Trie() {
        head = new Node();
    }
    
    public void insert(String word) {
        Node cur = head;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i] - 'a';
            if (cur.node[pos] == null) {
                cur.node[pos] = new Node();
            }
            cur = cur.node[pos];
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        Node cur = head;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i] - 'a';
            if (cur.node[pos] == null)
                return false;
            cur = cur.node[pos];
        }
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = head;
        char[] arr = prefix.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i] - 'a';
            if (cur.node[pos] == null)
                return false;
            cur = cur.node[pos];
        }
        return true;
    }
}

class Node {
    Node[] node = new Node[26];
    boolean end = false;    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */