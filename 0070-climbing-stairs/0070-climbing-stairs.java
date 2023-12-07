class Solution {
    public int climbStairs(int n) {
        // a, b, 2, 3, ... n
        int a = 1, b = 1;
        for (int i = 1; i < n; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }
}