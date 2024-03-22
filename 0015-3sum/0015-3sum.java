class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                    while (j < k && nums[j - 1] == nums[j])
                        j++;
                } else if (sum > 0) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    while (j < k && nums[j - 1] == nums[j])
                        j++;
                    k--;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return res;
    }
}