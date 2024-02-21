class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtracking(nums, 0);
        return ans;
    }

    void backtracking(int[] nums, int start) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}