class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1; // carry
            a = a ^ b; // no carry sum
            b = c;
        }
        return a;
    }
}