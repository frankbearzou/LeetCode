class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, path, ans);
        return new ArrayList(ans);
    }

    void backtracking(int[] nums, int start, List<Integer> path, Set<List<Integer>> ans) {
        ans.add(new ArrayList(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}