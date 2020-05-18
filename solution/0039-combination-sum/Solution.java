class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> list, int[] candidates, int remains, int start) {
        if (remains == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (remains - candidates[i] < 0)
                return;
            list.add(candidates[i]);
            backtracking(ans, list, candidates, remains - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
