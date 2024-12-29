class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            int cur = Math.min(k - i, 26);
            arr[i] = (char)('a' + cur - 1);
            k -= cur;
        }
        return new String(arr);
    }
}