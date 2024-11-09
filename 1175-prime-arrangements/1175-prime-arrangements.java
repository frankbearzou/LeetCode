class Solution {
    public int numPrimeArrangements(int n) {
        int mod = (int)1e9 + 7;
        int primeCount = count(n);
        int nonPrimeCount = n - primeCount;
        long ans = 1;
        for (int i = primeCount; i > 1; i--) {
            ans = (ans * i) % mod;
        }
        for (int i = nonPrimeCount; i > 1; i--) {
            ans = (ans * i) % mod;
        }
        return (int)ans;
    }

    int count(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    boolean isPrime(int n) {
        if (n == 1)
            return false;
        if (n == 2)
            return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}