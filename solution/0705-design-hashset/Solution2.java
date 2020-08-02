class MyHashSet {
    private List<List<Integer>> list;
    private final int size = 100;
    /** Initialize your data structure here. */
    public MyHashSet() {
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            list.add(new ArrayList<Integer>());
    }
    
    private int hash(int key) {
        return key % size;
    }
    
    public void add(int key) {
        int hash = hash(key);
        List<Integer> l = list.get(hash);
        l.add(key);
    }
    
    public void remove(int key) {
        int hash = hash(key);
        List<Integer> l = list.get(hash);
        l.removeIf(k -> k == key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
        List<Integer> l = list.get(hash);
        return l.contains(new Integer(key));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
