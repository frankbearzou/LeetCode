class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = candidates;
        dfs(0, target);
        return ans;
    }

    void dfs(int start, int target) {
        if (target == 0) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target)
                continue;
            path.add(nums[i]);
            dfs(i, target - nums[i]);
            path.remove(path.size() - 1);
        }
    }
}