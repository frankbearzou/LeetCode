class Solution {
    public int maxScore(String s) {
        int score = 0, left = 0, right = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (arr[0] == '0')
            left++;
        for (int i = 1; i < n; i++) {
            if (arr[i] == '1')
                right++;
        }
        score = left + right;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] == '0') {
                left++;
            } else {
                right--;
            }
            score = Math.max(score, left + right);
        }
        return score;
    }
}