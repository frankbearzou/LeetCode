class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int buy = -1, sell = -1, sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buy == -1 && i < prices.length - 1) {
                if (prices[i] < prices[i + 1])
                    buy = prices[i];
            } else {
                if (i < prices.length -1) {
                    if (prices[i] > prices[i + 1]) {
                        sum += prices[i] - buy;
                        buy = -1;
                    }
                } else if (buy != -1) {
                    sum += prices[i] - buy;
                }
                
            }
        }
        return sum;
    }
}
