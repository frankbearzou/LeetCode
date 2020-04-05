class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        
        System.arraycopy(arr, 0, nums, 0, nums.length);
    }
}
