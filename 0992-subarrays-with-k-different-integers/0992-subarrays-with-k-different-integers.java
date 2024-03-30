class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // atMost(3) - atMost(2) = exact 3
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    int atMost(int[] nums, int k) {
        int res = 0, l = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}