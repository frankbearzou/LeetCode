class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] ans = new int[n];
        int pos = -n;
        for (int i = 0; i < n; i++) {
            if (arr[i] == c)
                pos = i;
            ans[i] = i - pos;
        }
        for (int i = pos - 1; i >= 0; i--) {
            if (arr[i] == c)
                pos = i;
            ans[i] = Math.min(ans[i], pos - i);
        }
        return ans;
    }
}