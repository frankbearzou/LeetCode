class Solution {
    private Random random = new Random();
    TreeMap<Integer, Integer> map = new TreeMap<>();
    private int count;

    public Solution(int[] w) {
        for (int i = 0; i < w.length; i++) {
            count += w[i];
            map.put(count, i);
        }
    }
    
    public int pickIndex() {
        int key = map.ceilingKey(random.nextInt(count) + 1);
        return map.get(key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
