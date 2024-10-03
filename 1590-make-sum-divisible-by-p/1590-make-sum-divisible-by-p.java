class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int ans = n;
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }
        int target = sum % p;
        if (target == 0)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            int complement = (cur - target + p) % p;
            if (map.containsKey(complement)) {
                ans = Math.min(ans, i - map.get(complement));
            }
            map.put(cur, i);
        }
        if (ans == n)
            return -1;
        return ans;
    }
}