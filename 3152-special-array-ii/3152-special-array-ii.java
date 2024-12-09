class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1];
            if ((nums[i - 1] % 2 == 0 && nums[i] % 2 == 0) || (nums[i - 1] % 2 == 1 && nums[i] % 2 == 1))
                prefix[i]++;
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int t = prefix[r] - prefix[l];
            ans[i] = t == 0;
        }
        return ans;
    }
}