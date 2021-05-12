class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += cardPoints[i];
        }
        int curmax = max;

        int left = k - 1, right = cardPoints.length - 1;
        while (left >= 0) {
            curmax = curmax - cardPoints[left] + cardPoints[right];
            max = Math.max(max, curmax);
            left--;
            right--;
        }
        return max;
    }
}
