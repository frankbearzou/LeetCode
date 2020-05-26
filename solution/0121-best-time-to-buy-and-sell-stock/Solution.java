class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        
        stack.push(prices[0]);
        for (int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty() && stack.peek() > prices[i])
                stack.pop();
            if (stack.isEmpty())
                stack.push(prices[i]);
            else {
                max = Math.max(max, prices[i] - stack.peek());
            }
        }
        
        return max;
    }
}
