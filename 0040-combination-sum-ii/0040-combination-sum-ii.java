class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        backtracking(candidates, target, 0);
        return res;
    }

    void backtracking(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i] && !used[i - 1])
                continue;
            if (candidates[i] > target)
                continue;
            used[i] = true;
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}