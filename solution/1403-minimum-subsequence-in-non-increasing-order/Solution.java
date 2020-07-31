class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = t;
        }
        
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = 0;
        for (int val : nums)
            right += val;
        for (int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
            left += nums[i];
            right -= nums[i];
            if (left > right)
                return ans;
        }
        return ans;
    }
}
