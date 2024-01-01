class Solution {
    public int wiggleMaxLength(int[] nums) {
        int count = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] > nums[i - 1]) {
                count++;
                while (i < nums.length && nums[i] >= nums[i - 1])
                    i++;
            } else if (nums[i] < nums[i - 1]) {
                count++;
                while (i < nums.length && nums[i] <= nums[i - 1])
                    i++;
            } else {
                i++;
            }
        }
        return count;
    }
}