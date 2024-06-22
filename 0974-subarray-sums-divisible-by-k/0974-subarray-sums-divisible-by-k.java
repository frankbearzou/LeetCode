class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int mod = (prefix % k + k) % k;
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return count;
    }
}