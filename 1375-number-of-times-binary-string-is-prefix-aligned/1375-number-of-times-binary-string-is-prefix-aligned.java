class Solution {
    public int numTimesAllBlue(int[] flips) {
        int rightmost = 0;
        int n = flips.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            rightmost = Math.max(rightmost, flips[i]);
            if (rightmost == i + 1)
                count++;
        }
        return count;
    }
}