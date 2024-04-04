class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] *= -1;
                k--;
            }
        }
        int min = 10001;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        if (k % 2 == 0)
            return sum;
        else
            return sum - 2 * min;
    }
}