class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0)
            return new long[0];
        long[] res = new long[3];
        res = new long[]{num / 3 - 1, num / 3, num / 3 + 1};
        return res;
    }
}