class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int a = (int)s.charAt(i);
            int b = (int)t.charAt(i);
            arr[i] = Math.abs(a - b);
        }
        int len = 0;
        int sum = 0;
        int l = 0, r = 0;
        while (r < n) {
            sum += arr[r];
            while (l <= r && sum > maxCost) {
                sum -= arr[l];
                l++;
            }
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
}