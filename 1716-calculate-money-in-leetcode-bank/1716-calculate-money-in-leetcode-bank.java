class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int monday = 1;
        while (n >= 7) {
            total += (monday + monday + 6) * 7 / 2;
            n -= 7;
            monday++;
        }
        if (n > 0) {
            total += (monday + monday + n - 1) * n / 2;
        }
        return total;
    }
}