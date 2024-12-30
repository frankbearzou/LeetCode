class Solution {
    int low, high, zero, one;
    int[] cache;
    int mod = (int)1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        this.low = low;
        this.high = high;
        this.zero = zero;
        this.one = one;
        cache = new int[high + 1];
        Arrays.fill(cache, -1);
        long sum = 0;
        for (int i = low; i <= high; i++) {
            sum = (sum + dp(i)) % mod;
        }
        return (int)sum;
    }

    int dp(int index) {
        if (index == 0)
            return 1;
        if (cache[index] != -1)
            return cache[index];
        long sum = 0;
        if (index >= zero) {
            sum = (sum + dp(index - zero)) % mod;
        }
        if (index >= one) {
            sum = (sum + dp(index - one)) % mod;
        }
        cache[index] = (int)sum;
        return cache[index];
    }
}