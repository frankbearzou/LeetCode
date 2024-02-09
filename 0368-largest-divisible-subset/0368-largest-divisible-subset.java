class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int[] dp = new int[N];
        int[] pre = new int[N];
        int index = -1;
        int max = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (index != -1) {
            list.add(nums[index]);
            index = pre[index];
        }
        return list;
    }
}