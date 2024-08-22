class Solution {
    public int findComplement(int num) {
        int res = 0;
        int i = 1;
        while (num > 0) {
            if ((num & 1) == 0) {
                res = res | i;
            }
            i <<= 1;
            num >>= 1;
        }
        return res;
    }
}