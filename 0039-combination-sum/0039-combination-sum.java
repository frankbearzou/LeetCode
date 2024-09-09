class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(candidates, 0, target, path, res);
        return res;
    }

    void backtracking(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> res) {
        if (start >= candidates.length || target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // not select
        backtracking(candidates, start + 1, target, path, res);
        // select
        path.add(candidates[start]);
        backtracking(candidates, start, target - candidates[start], path, res);
        path.remove(path.size() - 1);
    }
}