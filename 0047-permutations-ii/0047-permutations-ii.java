class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, used, path, ans);
        return ans;
    }

    void backtracking(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if (used[i])
                continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, used, path, ans);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}