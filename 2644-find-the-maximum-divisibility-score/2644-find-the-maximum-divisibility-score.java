class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int max = 0;
        int divisor = Integer.MAX_VALUE;
        for (int i = 0; i < divisors.length; i++) {
            int count = getCount(nums, divisors[i]);
            if (count > max) {
                max = count;
                divisor = divisors[i];
            } else if (count == max && divisors[i] < divisor) {
                divisor = divisors[i];
            }
        }
        return divisor;
    }

    int getCount(int[] nums, int divisor) {
        int count = 0;
        for (int num : nums) {
            if (num % divisor == 0) {
                count++;
            }
        }
        return count;
    }
}