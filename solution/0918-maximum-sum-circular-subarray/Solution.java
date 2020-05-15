class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int total = 0, max = Integer.MIN_VALUE, curMax = 0, min = Integer.MAX_VALUE, curMin = 0;
        
        for (int i : A) {
            curMax = Math.max(i, curMax + i);
            max = Math.max(max, curMax);
            curMin = Math.min(i, curMin + i);
            min = Math.min(min, curMin);
            total += i;
        }
        
        return max > 0 ? Math.max(max, total - min) : max;
    }
}
