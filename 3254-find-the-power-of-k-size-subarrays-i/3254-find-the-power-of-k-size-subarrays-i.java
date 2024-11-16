class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = k - 1; i < n; i++) {
            boolean sorted = true;
            for (int j = 1; j < k; j++) {
                if (nums[i - j] != nums[i] - j) {
                    sorted = false;
                    break;
                }
            }
            if (sorted)
                ans[i - k + 1] = nums[i];
            else
                ans[i - k + 1] = -1;
        }
        return ans;
    }
}