class Solution {
    public int alternateDigitSum(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 10);
            n /= 10;
        }
        int i = 0;
        int res = 0;
        while (!stack.isEmpty()) {
            if (i++ % 2 == 0) {
                res += stack.pop();
            } else {
                res -= stack.pop();
            }
        }
        return res;
    }
}