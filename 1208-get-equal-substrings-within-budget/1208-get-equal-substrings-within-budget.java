class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int count = 0;
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int l = 0;
        int cur = 0;
        for (int r = 0; r < n; r++) {
            while (cur > maxCost) {
                cur -= arr[l];
                l++;
            }
            cur += arr[r];
            if (cur <= maxCost) {
                count = r - l + 1;
            }
        }
        return count;
    }
}