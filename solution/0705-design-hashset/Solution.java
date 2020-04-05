class MyHashSet {
    private List<List<Integer>> list;
    private int hashValue = 500;
    /** Initialize your data structure here. */
    public MyHashSet() {
		list = new ArrayList<>(hashValue);
        for (int i = 0; i < hashValue; i++) {
        	list.add(new ArrayList<>());
        }
    }
    
    public void add(int key) {
        int bucket = hash(key);
        list.get(bucket).add(key);
    }
    
    public void remove(int key) {
    	int bucket = hash(key);
    	list.get(bucket).removeIf(val -> val == key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	int bucket = hash(key);
    	return list.get(bucket).contains(key);
    }
    
    private int hash(int key) {
    	return key % hashValue;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
