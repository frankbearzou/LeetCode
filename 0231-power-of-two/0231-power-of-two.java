class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        long l = n;
        return (l & (l - 1)) == 0;
    }
}