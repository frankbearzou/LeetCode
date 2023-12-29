class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, path, ans);
        return new ArrayList(ans);
    }

    void backtracking(int[] nums, int start, List<Integer> path, Set<List<Integer>> ans) {
        if (path.size() >= 2) {
            ans.add(new ArrayList(path));
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1))
                continue;
            path.add(nums[i]);
            backtracking(nums, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}