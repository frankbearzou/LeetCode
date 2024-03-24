class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a - 1] == nums[a])
                continue;
            for (int b = a + 1; b < n - 2; b++) {
                if (b - a > 1 && nums[b - 1] == nums[b])
                    continue;
                if (nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target)
                    break;
                if (nums[a] + nums[b] + nums[n - 2] + nums[n - 1] < target)
                    continue;
                int c = b + 1, d = n - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum < target) {
                        c++;
                        while (c < d && nums[c - 1] == nums[c])
                            c++;
                    } else if (sum > target) {
                        d--;
                        while (c < d && nums[d] == nums[d + 1])
                            d--;
                    } else {
                        res.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        while (c < d && nums[c - 1] == nums[c])
                            c++;
                        d--;
                        while (c < d && nums[d] == nums[d + 1])
                            d--;
                    }
                }
            }
        }
        return res;
    }
}