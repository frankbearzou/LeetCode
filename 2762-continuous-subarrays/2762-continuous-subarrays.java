class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int l = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            ans += i - l + 1;
        }
        return ans;
    }
}