class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1, count = 9;
        while (n > count) {
            n -= count;
            start *= 10;
            digit++;
            count = 9 * start * digit;
        }
        String num = String.valueOf(start + (n - 1) / digit);
        return num.charAt((n - 1) % digit) - '0';
    }
}