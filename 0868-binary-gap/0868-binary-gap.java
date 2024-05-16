class Solution {
    public int binaryGap(int n) {
        int res = 0;
        int pre = 0;
        int i = 0;
        while (n > 0 && ((n & 1) == 0)) {
            n >>= 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res = Math.max(res, i - pre);
                pre = i;
            }
            n >>= 1;
            i++;
        }
        return res;
    }
}