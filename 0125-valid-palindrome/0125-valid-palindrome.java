class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                str += (char)('a' + c - 'A');
            } else if (c >= 'a' && c <= 'z') {
                str += c;
            } else if (c >= '0' && c <= '9') {
                str += c;
            }
        }
        char[] arr = str.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l++] != arr[r--]) {
                return false;
            }
        }
        return true;
    }
}