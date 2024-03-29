class Solution {
    public int smallestEvenMultiple(int n) {
        return (n & 1) == 0 ? n : 2 * n;
    }
}