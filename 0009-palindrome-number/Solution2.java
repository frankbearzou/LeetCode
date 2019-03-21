class Solution2 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int res = x;
        int rev = 0;
        while (res != 0) {
            rev = rev * 10 + res % 10;
            res = res / 10;
        }
        return rev == x;
    }
}
