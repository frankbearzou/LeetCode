class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0)
            return false;
        Set<Integer> used = new HashSet<>();
        return backtracking(nums, k, 0, 0, sum / k, used);
    }

    boolean backtracking(int[] nums, int k, int start, int sum, int target, Set<Integer> used) {
        if (k == 1)
            return true;
        if (start >= nums.length)
            return false;
        if (sum == target)
            return backtracking(nums, k - 1, 0, 0, target, used);
        for (int i = start; i < nums.length; i++) {
            if (used.contains(i) || sum + nums[i] > target)
                continue;
            used.add(i);
            if (backtracking(nums, k, i + 1, sum + nums[i], target, used))
                return true;
            used.remove(i);
        }
        return false;
    }
}