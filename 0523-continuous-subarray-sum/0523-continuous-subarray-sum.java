class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // congruence modulo
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod) && i - map.get(mod) >= 2) {
                return true;
            }
            map.put(mod, i);
        }
        return false;
    }
}