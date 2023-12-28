class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(candidates, 0, path, ans, target);
        return ans;
    }

    void backtracking(int[] candidates, int start, List<Integer> path, List<List<Integer>> ans, int target) {
        if (target == 0) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target)
                continue;
            path.add(candidates[i]);
            backtracking(candidates, i, path, ans, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}