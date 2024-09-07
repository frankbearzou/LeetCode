class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        this.nums = nums;
        dfs(0);
        return ans;
    }

    void dfs(int i) {
        if (i == n) {
            ans.add(new ArrayList(path));
            return;
        }
        dfs(i + 1);
        path.add(nums[i]);
        dfs(i + 1);
        path.removeLast();
    }
}