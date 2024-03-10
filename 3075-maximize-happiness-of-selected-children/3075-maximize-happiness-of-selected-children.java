class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int n = happiness.length;
        Arrays.sort(happiness);
        for (int i = n - 1, count = 0; i >= n - k && count < n; i--, count++) {
            if (happiness[i] > count)
                ans += happiness[i] - count;
        }
        return ans;
    }
}