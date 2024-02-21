class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    int[] nums;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        nums = candidates;
        used = new boolean[nums.length];
        dfs(0, target);
        return ans;
    }

    void dfs(int start, int target) {
        if (target == 0) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if (used[i])
                continue;
            if (nums[i] > target)
                continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(i + 1, target - nums[i]);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}