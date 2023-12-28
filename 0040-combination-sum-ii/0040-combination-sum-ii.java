class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, 0, path, ans, target);
        return ans;
    }

    void backtracking(int[] candidates, int start, List<Integer> path, List<List<Integer>> ans, int target) {
        if (target == 0) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                continue;
            path.add(candidates[i]);
            backtracking(candidates, i + 1, path, ans, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}