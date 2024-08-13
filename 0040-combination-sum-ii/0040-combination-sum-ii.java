class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0, target);
        return res;
    }

    void backtracking(int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i])
                continue;
            if (candidates[i] > target)
                continue;
            path.add(candidates[i]);
            backtracking(candidates, i + 1, target - candidates[i]);
            path.removeLast();
        }
    }
}