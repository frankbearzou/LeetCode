class Solution {
    int[] nums;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        dfs();
        return ans;
    }

    void dfs() {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            dfs();
            path.removeLast();
        }
    }
}