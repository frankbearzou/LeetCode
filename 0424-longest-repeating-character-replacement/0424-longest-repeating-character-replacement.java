class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, ans = 0;
        int[] map = new int[26];

        char[] arr = s.toCharArray();
        int len = arr.length;
        while (r < len) {
            map[arr[r] - 'A']++;
            while (r - l + 1 - max(map) > k) {
                map[arr[l] - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }

    private int max(int[] map) {
        int max = 0;
        for (int v : map) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }
}