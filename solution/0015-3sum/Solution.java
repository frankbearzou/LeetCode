class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                if (-nums[i] == nums[lo] + nums[hi]) {
                    ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < nums.length - 1 && nums[lo] == nums[lo + 1])
                        lo++;
                    while (hi > 0 && nums[hi] == nums[hi - 1])
                        hi--;
                    lo++;
                    hi--;
                } else if (-nums[i] < nums[lo] + nums[hi])
                    hi--;
                else
                    lo++;
            }
        }
        
        return ans;
    }
}
