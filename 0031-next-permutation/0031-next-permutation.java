class Solution {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    // swap
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    // sort after i
                    Arrays.sort(nums, i + 1, N);
                    return;
                }
            }
        }
        // reverse
        int l = 0, r = N - 1;
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}