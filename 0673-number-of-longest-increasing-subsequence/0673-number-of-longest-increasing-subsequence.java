class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N == 1)
            return 1;
        int max = 0;
        int[] dp = new int[N];
        int[] count = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == max) {
                cnt += count[i];
            }
        }
        return cnt;
    }
}