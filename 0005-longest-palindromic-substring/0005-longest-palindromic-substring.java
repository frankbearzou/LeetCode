class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int len = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j <= i + 1; j++) {
                int l = i, r = j;
                while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
                    if (r - l + 1 > len) {
                        len = r - l + 1;
                        ans = s.substring(l, r + 1);
                    }
                    l--; r++;
                }
            }
        }
        return ans;
    }
}