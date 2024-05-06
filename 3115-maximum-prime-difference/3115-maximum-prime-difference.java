class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i])) {
                l = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (isPrime(nums[i])) {
                r = i;
                break;
            }
        }
        return r - l;
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
}