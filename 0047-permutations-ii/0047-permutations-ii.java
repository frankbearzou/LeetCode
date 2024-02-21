class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        used = new boolean[nums.length];
        backtracking(0);
        return ans;
    }

    void backtracking(int index) {
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
            backtracking(i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}