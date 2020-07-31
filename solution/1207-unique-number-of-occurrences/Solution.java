class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        for (int v : map.values()) {
            if (!set.add(v))
                return false;
        }
        
        return true;
    }
}
