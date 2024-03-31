class Solution {
    public int[] shortestToChar(String s, char c) {
        int diff = -1;
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 10000);
        // left to right
        for (int i = 0; i < n; i++) {
            if (arr[i] == c) {
                ans[i] = 0;
                diff = 1;
            } else if (diff != -1) {
                ans[i] = Math.min(ans[i], diff++);
            }
        }
        diff = -1;
        // right to left
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == c) {
                ans[i] = 0;
                diff = 1;
            } else if (diff != -1) {
                ans[i] = Math.min(ans[i], diff++);
            }
        }
        return ans;
    }
}