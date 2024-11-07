class Solution {
    public int largestCombination(int[] candidates) {
        int[] bits = new int[32];
        for (int candidate : candidates) {
            int bit = 0;
            while (candidate > 0) {
                bits[bit] += candidate & 1;
                candidate >>= 1;
                bit++;
            }
        }
        int max = 0;
        for (int bit : bits) {
            max = Math.max(max, bit);
        }
        return max;
    }
}