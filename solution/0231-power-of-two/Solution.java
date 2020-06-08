class Solution {
    public boolean isPowerOfTwo(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n & 1);
            n >>= 1;
        }
        return sum == 1;
    }
}
