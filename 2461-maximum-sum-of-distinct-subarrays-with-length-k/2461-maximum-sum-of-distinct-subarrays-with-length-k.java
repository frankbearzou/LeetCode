class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        int n = nums.length;
        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            sum += nums[r];
            if (r >= k) {
                sum -= nums[l];
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            if (r - l + 1 == k) {
                if (map.size() == k) {
                    ans = Math.max(ans, sum);
                }
            }
        }
        return ans;
    }
}