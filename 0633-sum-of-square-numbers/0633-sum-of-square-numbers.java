class Solution {
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a * a <= c; a++) {
            for (int b = 0; b * b <= c; b++) {
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
    }
}