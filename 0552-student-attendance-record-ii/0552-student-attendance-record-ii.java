class Solution {
    Integer[][][] cache;
    int mod = 1000000007;

    public int checkRecord(int n) {
        cache = new Integer[n + 1][2][3];
        return checkRecord(n, 0, 0);
    }

    int checkRecord(int n, int totalAbsent, int consecutiveLate) {
        if (totalAbsent >= 2 || consecutiveLate >= 3)
            return 0;
        if (n == 0)
            return 1;
        if (cache[n][totalAbsent][consecutiveLate] != null)
            return cache[n][totalAbsent][consecutiveLate];
        int total = checkRecord(n - 1, totalAbsent + 1, 0) % mod; // Absent
        total = (total + checkRecord(n - 1, totalAbsent, consecutiveLate + 1)) % mod; // Late
        total = (total + checkRecord(n - 1, totalAbsent, 0)) % mod; // Present
        return cache[n][totalAbsent][consecutiveLate] = total;
    }
}