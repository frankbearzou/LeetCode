class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int maxPrev = values[0] + 0;
        for (int j = 1; j < values.length; j++) {
            int cur = values[j] - j;
            max = Math.max(max, maxPrev + cur);
            maxPrev = Math.max(maxPrev, cur);
        }
        return max;
    }
}