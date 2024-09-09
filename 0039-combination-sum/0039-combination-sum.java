class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] candidates;
    int n;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        n = candidates.length;
        dfs(0, target);
        return res;
    }

    void dfs(int start, int target) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        if (start == n)
            return;
        // not choose
        dfs(start + 1, target);
        // choose
        if (candidates[start] <= target) {
            path.add(candidates[start]);
            dfs(start, target - candidates[start]);
            path.removeLast();
        }
    }
}