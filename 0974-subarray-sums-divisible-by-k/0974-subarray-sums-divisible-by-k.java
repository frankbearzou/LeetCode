class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % k;
            int mod = (sum + k) % k;
            if (map.containsKey(mod)) {
                ans += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}