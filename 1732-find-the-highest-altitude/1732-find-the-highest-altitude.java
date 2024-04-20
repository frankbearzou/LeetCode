class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int i = 0;
        for (int g : gain) {
            i += g;
            max = Math.max(max, i);
        }
        return max;
    }
}