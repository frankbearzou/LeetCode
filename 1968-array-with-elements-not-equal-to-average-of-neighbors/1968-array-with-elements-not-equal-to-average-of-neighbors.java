class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            int a = nums[i - 1];
            int b = nums[i];
            int c = nums[i + 1];
            if ((a + c) == b * 2) {
                nums[i - 1] = b;
                nums[i] = c;
                nums[i + 1] = a;
            }
        }
        return nums;
    }
}