class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = 0;
        int l = 0;
        int count = 0;
        int n = nums.length;
        for (int num : nums)
            if (num > max)
                max = num;
        
        for (int r = 0; r < n; r++) {
            if (nums[r] == max)
                count++;
            while (count >= k) {
                res += n - r;
                if (nums[l++] == max)
                    count--;
            }
        }
        return res;
    }
}