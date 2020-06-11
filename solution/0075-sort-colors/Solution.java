class Solution {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for (int i : nums)
            arr[i]++;
        for (int i = 0; i < nums.length; i++) {
            if (arr[0] > 0) {
                nums[i] = 0;
                arr[0]--;
            } else if (arr[1] > 0) {
                nums[i] = 1;
                arr[1]--;
            } else if (arr[2] > 0) {
                nums[i] = 2;
                arr[2]--;
            }
        }
    }
}
