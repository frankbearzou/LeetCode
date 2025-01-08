class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        List<Integer> path = new ArrayList<>();
        dfs(0, target, path);
        return ans;
    }

    void dfs(int index, int target, List<Integer> path) {
        if (index == candidates.length)
            return;
        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // not choose
        dfs(index + 1, target, path);
        // choose
        path.add(candidates[index]);
        dfs(index, target - candidates[index], path);
        path.removeLast();
    }
}