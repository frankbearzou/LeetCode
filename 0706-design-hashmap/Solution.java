class MyHashMap {
	class Pair {
		int key, value;
		Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int hashValue = 500;
	private List<List<Pair>> list = new ArrayList<>(hashValue);

    /** Initialize your data structure here. */
    public MyHashMap() {
        for (int i = 0; i < hashValue; i++) {
        	list.add(new ArrayList<>());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = hash(key);
        if (get(key) == -1) {
        	list.get(bucket).add(new Pair(key, value));
        } else {
        	List<Pair> l = list.get(bucket);
        	for (int i = 0; i < l.size(); i++) {
        		if (l.get(i).key == key)
        			l.get(i).value = value;
        	}
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	int bucket = hash(key);
    	List<Pair> l = list.get(bucket);
    	for (int i = 0; i < l.size(); i++) {
    		if (l.get(i).key == key)
    			return l.get(i).value;
    	}
    	return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (get(key) == -1)
        	return;
        int bucket = hash(key);
        list.get(bucket).removeIf(pair -> pair.key == key);
    }
    
    private int hash(int key) {
    	return key % hashValue;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
