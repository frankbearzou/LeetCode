class Solution {
    public int waysToSplitArray(int[] nums) {
        int count = 0;
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            int l = prefix[i];
            int r = prefix[n - 1] - prefix[i];
            if (l >= r)
                count++;
        }
        return count;
    }
}