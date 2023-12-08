class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j <= i + 1; j++) {
                int l = i, r = j;
                while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
                    ans++;
                    l--; r++;
                }
            }
        }
        return ans;
    }
}