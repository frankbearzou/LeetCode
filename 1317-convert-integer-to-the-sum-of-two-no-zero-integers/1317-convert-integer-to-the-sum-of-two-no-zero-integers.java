class Solution {
    public int[] getNoZeroIntegers(int n) {
        int l = 1, r = n - 1;
        while (l <= r) {
            if (containsZero(l) || containsZero(r)) {
                l++;
                r--;
            } else {
                return new int[]{l, r};
            }
        }
        return new int[]{0};
    }

    boolean containsZero(int n) {
        while (n > 0) {
            if ((n % 10) == 0)
                return true;
            n /= 10;
        }
        return false;
    }
}