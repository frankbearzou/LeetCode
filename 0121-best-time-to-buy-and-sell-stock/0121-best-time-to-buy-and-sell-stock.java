class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, ans = 0;
        while (r < prices.length) {
            if (prices[l] > prices[r]) {
                l = r;
            } else {
                ans = Math.max(ans, prices[r] - prices[l]);
            }
            r++;
        }
        return ans;
    }
}