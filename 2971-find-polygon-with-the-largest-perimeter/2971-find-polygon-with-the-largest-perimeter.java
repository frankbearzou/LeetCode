class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += nums[i];
        }
        for (int i = N - 2; i >= 1; i--) {
            if (sum > nums[i + 1])
                return sum + nums[i + 1];
            sum -= nums[i];
        }
        return -1;
    }
}