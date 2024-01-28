class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            int l = preSum[i] - k;
            ans += map.getOrDefault(l, 0);
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return ans;
    }
}