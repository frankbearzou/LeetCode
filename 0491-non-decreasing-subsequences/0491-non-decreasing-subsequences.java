class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, path, ans);
        return new ArrayList(ans);
    }

    void backtracking(int[] nums, int start, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() >= 2) {
            ans.add(new ArrayList(path));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1))
                continue;
            if (used.contains(nums[i]))
                continue;
            used.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}