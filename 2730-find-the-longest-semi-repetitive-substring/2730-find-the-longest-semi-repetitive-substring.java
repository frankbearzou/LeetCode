class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int res = 1;
        int l = 0;
        int same = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int r = 1; r < n; r++) {
            if (arr[r - 1] == arr[r] && ++same > 1) {
                l++;
                while (arr[l - 1] != arr[l])
                    l++;
                same = 1;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}