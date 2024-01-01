class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int price : prices) {
            if (stack.isEmpty()) {
                stack.push(price);
            } else {
                if (price <= stack.peek()) {
                    stack.push(price);
                } else {
                    sum += price - stack.pop();
                    stack.push(price);
                }
            }
        }
        return sum;
    }
}