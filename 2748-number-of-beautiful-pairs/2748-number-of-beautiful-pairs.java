class Solution {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = first(nums[i]);
                int b = last(nums[j]);
                if (gcd(a, b) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    int first(int n) {
        while (n >= 10) {
            n /= 10;
        }
        return n;
    }

    int last(int n) {
        return n % 10;
    }

    int gcd(int a, int b) {
        int res = Math.min(a, b);
        while (res > 0) {
            if ((a % res == 0) && (b % res == 0))
                return res;
            res--;
        }
        return res;
    }
}