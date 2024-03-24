class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE, distance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < distance) {
                    distance = Math.abs(sum - target);
                    res = sum;
                }
                if (sum < target)
                    l++;
                else
                    r--;
            }
        }
        return res;
    }
}