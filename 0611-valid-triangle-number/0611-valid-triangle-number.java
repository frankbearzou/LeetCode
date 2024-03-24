class Solution {
    public int triangleNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                while (l < r && nums[i] + nums[l] <= nums[r])
                    r--;
                res += r - l;
                l++;
                r = n - 1;
            }
        }
        return res;
    }
}