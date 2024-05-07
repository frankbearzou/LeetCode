class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(getOnes(i)))
                count++;
        }
        return count;
    }

    boolean isPrime(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (gcd(i, num) != 1)
                return false;
        }
        return true;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    int getOnes(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}