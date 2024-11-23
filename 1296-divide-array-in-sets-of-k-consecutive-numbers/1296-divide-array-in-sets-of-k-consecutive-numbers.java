class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0)
            return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length / k; i++) {
            int firstkey = map.ceilingKey(0);
            int t = map.get(firstkey);
            if (t > 1) {
                map.put(firstkey, t - 1);
            } else {
                map.remove(firstkey);
            }
            for (int j = 1; j < k; j++) {
                int key = firstkey + j;
                Integer v = map.get(key);
                if (v == null)
                    return false;
                if (v > 1) {
                    map.put(key, v - 1);
                } else {
                    map.remove(key);
                }
            }
        }
        return true;
    }
}