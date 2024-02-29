class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int amount : account) {
                sum += amount;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}