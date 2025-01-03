class Solution {
    public int reductionOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = tmp;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i])
                ans += i;
        }
        return ans;
    }
}