class Solution {
    // a = a ^ b
    // b = (a & b) << 1
    public int getSum(int a, int b) {
        while (b != 0) {
            int t = a ^ b;
            b = (a & b) << 1;
            a = t;
        }
        return a;
    }
}