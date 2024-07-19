class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int max = releaseTimes[0];
        int n = releaseTimes.length;
        for (int i = 1; i < n; i++) {
            int cur = releaseTimes[i] - releaseTimes[i - 1];
            if (cur > max) {
                max = cur;
                res = keysPressed.charAt(i);
            } else if (cur == max && keysPressed.charAt(i) > res) {
                res = keysPressed.charAt(i);
            }
        }
        return res;
    }
}