class Solution {
    public boolean primeSubOperation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (isSorted(nums))
                return true;
            if (i == 0) {
                nums[i] = getPrime(nums[i]);
            } else {
                nums[i] = getPrime(nums[i] - nums[i - 1]);
            }
        }
        if (isSorted(nums))
            return true;
        return false;
    }

    boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i])
                return false;
        }
        return true;
    }

    int getPrime(int num) {
        for (int i = num - 1; i >= 2; i--) {
            if (isPrime(i))
                return i;
        }
        return num;
    }

    boolean isPrime(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}