class RandomizedSet {
    private List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (list.contains(val))
            return false;
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return list.remove(new Integer(val));
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        int next = r.nextInt(list.size());
        return list.get(next);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
