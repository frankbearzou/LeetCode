class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - low);
            }
        }
        return ans;
    }
}